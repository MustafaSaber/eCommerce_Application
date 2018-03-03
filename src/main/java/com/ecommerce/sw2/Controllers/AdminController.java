package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.AdminUser;
import com.ecommerce.sw2.Models.NormalUser;
import com.ecommerce.sw2.Models.User;
import com.ecommerce.sw2.Repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminRepo adminRepo;
    @RequestMapping("/register")
    public String addAdmin(
            @RequestParam("Name") String name
            , @RequestParam("Email") String email
            , @RequestParam("Username") String username
            , @RequestParam("password") String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        AdminUser n = new AdminUser(name , email , username , password);
        if (adminRepo.exists(username))
            return "index";
        adminRepo.save(n);
        return "Saved";
    }

    @RequestMapping("/all")
    public @ResponseBody Iterable<AdminUser> getAllUsers() {
        // This returns a JSON or XML with the users
        Iterable<AdminUser> iu = adminRepo.findAll();
        return iu;
    }
}
