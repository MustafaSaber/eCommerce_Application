package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.*;
import com.ecommerce.sw2.Repositories.StoreOwnerRepo;
import com.ecommerce.sw2.Repositories.StoreRepo;
import com.ecommerce.sw2.Repositories.SuggestedStoreRepo;
import com.ecommerce.sw2.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
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
    @Autowired
    private SuggestedStoreRepo ssr;

    @GetMapping("/storeOwnerLogin")
    public String Login()
    {
        return "storeOwnerLogin";
    }

    @PostMapping("/storeOwnerLogin")
    public String login(
            @RequestParam("Username") String username,
            @RequestParam("password") String password , Model model) {
        StoreOwnerUser na = storeOwnerRepo.findStoreOwnerUserByUsernameAndPassword(username, password);
        if(na != null) {

            Vector<Store> stores = stRe.findByStoreOwner(na.getUsername());
            model.addAttribute("sname",na.getName());
            if (stores == null || stores.size() <=0) {
                model.addAttribute("found", "0");
                return "StoreOwnerAfterLogin";
            }
            model.addAttribute("found","1");
            model.addAttribute("rows",stores);
            return "StoreOwnerAfterLogin";
        }
        else
            return "storeOwnerLogin";
    }

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
        return "index";
    }
    @RequestMapping("/all")
    public @ResponseBody Iterable<StoreOwnerUser> getAllUsers() {
        // This returns a JSON or XML with the users
        Iterable<StoreOwnerUser> iu = storeOwnerRepo.findAll();
        return iu;
    }



    @GetMapping("/addStore")
    public String getAddStore()
    {
        return "AddStore";
    }

    @PostMapping("/addStore")
    public String postAddStore(@RequestParam("Name") String storename ,
                               @RequestParam("StoreOwnerName") String son , Model model)
    {
        Store temp = stRe.findByNameAndAndStoreOwner(storename , son);
        if(temp == null)
        {
            SuggestedStore s = new SuggestedStore(storename , son);
            ssr.save(s);
        }
        Vector<Store> stores = stRe.findByStoreOwner(son);
        model.addAttribute("sname",son);
        if (stores == null || stores.size() <=0) {
            model.addAttribute("found", "0");
            return "StoreOwnerAfterLogin";
        }
        model.addAttribute("found","1");
        model.addAttribute("rows",stores);
        return "StoreOwnerAfterLogin";
    }

}
