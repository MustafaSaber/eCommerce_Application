package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.*;
import com.ecommerce.sw2.Repositories.*;
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
@SessionAttributes("User")
public class StoreOwnerController {

    @Autowired
    private StoreOwnerRepo storeOwnerRepo;
    @Autowired
    private StoreRepo stRe;
    @Autowired
    private SuggestedStoreRepo ssr;
    @Autowired
    private ProductRepo  productRepo;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private ModelRepo modelRepo;

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
            if(!model.containsAttribute("User"))
                model.addAttribute("User" , new StoreOwnerUser("", "" , na.getUsername(), ""));
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

    @GetMapping("/register")
    public String RedirectRegister() { return "storeOwnerRegister"; }

    @PostMapping("/register")
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
    public String postAddStore(@RequestParam("Name") String storename, Model model,
                               @ModelAttribute("User") StoreOwnerUser storeOwnerUser)
    {
        Store temp = stRe.findByNameAndAndStoreOwner(storename , storeOwnerUser.getUsername());
        if(temp == null)
        {
            SuggestedStore s = new SuggestedStore(storename , storeOwnerUser.getUsername());
            ssr.save(s);
        }
        Vector<Store> stores = stRe.findByStoreOwner(storeOwnerUser.getUsername());
        model.addAttribute("sname",storeOwnerUser.getUsername());
        if (stores == null || stores.size() <=0) {
            model.addAttribute("found", "0");
            return "StoreOwnerAfterLogin";
        }
        model.addAttribute("found","1");
        model.addAttribute("rows",stores);
        return "StoreOwnerAfterLogin";
    }
    @GetMapping("/addNewProduct")
    public String openAddProduct(){
        return "AddProduct";
    }
    @RequestMapping("/addNewProduct")
    public String AddNewProduct(
            @RequestParam("model") String modelName
            , @RequestParam("price") Double price
            , @RequestParam("store") String store
            , @RequestParam("brand")  String brandname) {
        // This returns a JSON or XML with the users

        if(!modelRepo.existsById(modelName))
            return "NotSavedProduct";
        else {
            com.ecommerce.sw2.Models.Model model = modelRepo.findByName(modelName);
            Brand brand = brandRepo.findByName(brandname);
            Store store1 = stRe.findByName(store);
            Product p = new Product(model,price,store1,brand);
            productRepo.save(p);
            return "SaveProduct";
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomepage(Model model){
        return "StoreOwnerAfterLogin";
    }

}
