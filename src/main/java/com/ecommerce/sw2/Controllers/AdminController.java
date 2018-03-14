package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.*;
import com.ecommerce.sw2.Repositories.AdminRepo;
import com.ecommerce.sw2.Repositories.BrandRepo;
import com.ecommerce.sw2.Repositories.ModelRepo;
import com.ecommerce.sw2.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private ModelRepo modelRepo;

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
        return "Saved";
    }

    @PostMapping("/adminLogin")
    public String login(
            @RequestParam("Username") String username,
            @RequestParam("password") String password) {
        AdminUser na = adminRepo.findAdminUserByUsernameAndPassword(username, password);
        if(na != null)
            return "HomePage";
        else
            return "adminLogin";
    }
    @RequestMapping("/all")
    public @ResponseBody Iterable<AdminUser> getAllUsers() {
        // This returns a JSON or XML with the users
        Iterable<AdminUser> iu = adminRepo.findAll();
        return iu;
    }
    @RequestMapping("/addNewModel")
    public String AddNewModel(
              @RequestParam("model") String modelName
            , @RequestParam("brand")  String brandname) {

        if (modelRepo.existsById(modelName.toLowerCase()))
            return "NotSavedModel";
        else {
            Model model = new Model(modelName, brandname);

            if (!brandRepo.existsById(brandname)) {
                Brand brand = new Brand(brandname);
                brandRepo.save(brand);
            }
            modelRepo.save(model);
            return "SaveModel";
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
}

