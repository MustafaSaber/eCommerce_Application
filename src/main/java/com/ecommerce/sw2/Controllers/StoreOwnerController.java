package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.NormalUser;
import com.ecommerce.sw2.Models.Store;
import com.ecommerce.sw2.Models.StoreOwnerUser;
import com.ecommerce.sw2.Models.User;
import com.ecommerce.sw2.Repositories.StoreOwnerRepo;
import com.ecommerce.sw2.Repositories.StoreRepo;
import com.ecommerce.sw2.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Vector;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@RequestMapping("/storeowner")
@Controller
public class StoreOwnerController {
    @Autowired
    private StoreOwnerRepo storeOwnerRepo;
    @Autowired
    private StoreRepo stRe;

    @RequestMapping("/register")
    public String addStoreOwner(
            @RequestParam("Name") String name
            , @RequestParam("Email") String email
            , @RequestParam("Username") String username
            , @RequestParam("password") String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        StoreOwnerUser n = new StoreOwnerUser(name , email , username , password);
        if (storeOwnerRepo.existsById(username))
            return "index";

        storeOwnerRepo.save(n);
        return "Saved";
    }
    @RequestMapping("/all")
    public @ResponseBody Iterable<StoreOwnerUser> getAllUsers() {
        // This returns a JSON or XML with the users
        Iterable<StoreOwnerUser> iu = storeOwnerRepo.findAll();
        return iu;
    }


    @PostMapping("/logged")
    public String HomeAfterLogin(@RequestParam String storeowner , Model model)
    {
        Vector<Store> stores = stRe.findByStoreOwner(storeowner);
        model.addAttribute("sname",storeowner);
        if (stores == null || stores.size() <=0) {
            model.addAttribute("found", "0");
            return "StoreOwnerAfterLogin";
        }
        model.addAttribute("found","1");
        model.addAttribute("rows",stores);
        return "StoreOwnerAfterLogin";
    }

    @GetMapping("/addStore")
    public String getAddStore()
    {
        return "AddStore";
    }

    @PostMapping("/addStore")
    public String postAddStore()
    {
        return "AddStore";
    }
}
