package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.*;
import com.ecommerce.sw2.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Vector;


@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private ModelRepo modelRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private SuggestedStoreRepo ssr;
    @Autowired
    private StoreRepo storeRepo;

    @GetMapping("/adminLogin")
    public String Login()
    {
        return "adminLogin";
    }

    @RequestMapping("/register")
    public String addAdmin(
            @RequestParam("Name") String name
            , @RequestParam("Email") String email
            , @RequestParam("Username") String username
            , @RequestParam("password") String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        AdminUser n = new AdminUser(name , email , username , password);
        if (adminRepo.existsById(username))
            return "index";
        adminRepo.save(n);
        return "index";
    }

    @PostMapping("/adminLogin")
    public String login(
            @RequestParam("Username") String username,
            @RequestParam("password") String password) {
        AdminUser na = adminRepo.findAdminUserByUsernameAndPassword(username, password);
        if(na != null)
            return "AdminAfterLogin";
        else
            return "adminLogin";
    }
    @RequestMapping("/all")
    public @ResponseBody Iterable<AdminUser> getAllUsers() {
        // This returns a JSON or XML with the users
        Iterable<AdminUser> iu = adminRepo.findAll();
        return iu;
    }

    @RequestMapping("/addNewProduct")
    public String AddNewProduct(
            @RequestParam("productID") Integer productID
            , @RequestParam("model") String modelName
            , @RequestParam("price") Double price
            , @RequestParam("brand")  String brandname) {
        // This returns a JSON or XML with the users

        Product p = new Product();

        if(productRepo.existsById(productID))
            return "NotSavedProduct";
        else {
            p.setProductID(productID);
            p.setPrice(price);
            if (brandRepo.existsById(brandname)) {
                p.setBrand(brandname);
            } else {
                Brand brand = new Brand(brandname);
                p.setBrand(brandname);
                brandRepo.save(brand);
            }
            if (modelRepo.existsById(modelName)) {
                p.setModel(modelName);
            } else {
                com.ecommerce.sw2.Models.Model model = new com.ecommerce.sw2.Models.Model(modelName, p.getBrand());
                p.setModel(modelName);
                modelRepo.save(model);
            }
            productRepo.save(p);
            return "SaveProduct";
        }
    }

    @RequestMapping("/addNewBrand")
    public String AddNewBrand(@RequestParam("brand")  String brandname)
    {
        if(brandRepo.existsById(brandname))
            return "NotSavedBrand";
        else {
            Brand brand = new Brand(brandname);
            brandRepo.save(brand);
            return "SaveBrand";
        }
    }

    @GetMapping("/confirmStores")
    public String GetAddNewStore(Model model)
    {
        Iterable<SuggestedStore> stores = ssr.findAll();
        Vector<SuggestedStore> list = new Vector();
        for(SuggestedStore s :stores) list.add(s);
        if (list == null || list.size() <=0) {
            model.addAttribute("found", "0");
            return "suggestedStores";
        }
        model.addAttribute("found","1");
        model.addAttribute("rows",list);
        return "suggestedStores";
    }

    @PostMapping("/confirmStores")
    public String postAddNewStore(@RequestParam("storeName") String sn,
                                  @RequestParam("store_owner_name") String son ,
                                  Model model)
    {

        SuggestedStore s = ssr.findByNameAndStoreOwner(sn , son);
        if(s != null) {
            storeRepo.save(new Store(s.getName(), s.getStoreOwner()));
             ssr.delete(s);
        }

        Iterable<SuggestedStore> stores = ssr.findAll();
        Vector<SuggestedStore> list = new Vector();
        for (SuggestedStore temp : stores) list.add(temp);
        if (list == null || list.size() <= 0) {
            model.addAttribute("found", "0");
            return "suggestedStores";
        }
        model.addAttribute("found", "1");
        model.addAttribute("rows", list);
        return "suggestedStores";
    }

}

