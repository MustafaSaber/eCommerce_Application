package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.NormalUser;
import com.ecommerce.sw2.Models.User;
import com.ecommerce.sw2.Repositories.NormalRepo;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import javax.validation.constraints.Null;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@RequestMapping("/normal")
@Controller
public class NormalController {
    @Autowired
    private NormalRepo normalRepo;


    @RequestMapping("")
    public String enter()
    {
        return "normalLogin";
    }

    @RequestMapping("/register")
    public String addNewUser (
            @RequestParam("Name") String name
            , @RequestParam("Email") String email
            , @RequestParam("Username") String username
            , @RequestParam("password") String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        NormalUser n = new NormalUser(name , email , username , password);
        if (normalRepo.existsById(username))
            return "index";
        normalRepo.save(n);
        return "Saved";
    }
    @PostMapping("/login")
    public String login(
            @RequestParam("Username") String username,
            @RequestParam("password") String password) {
        NormalUser nu =normalRepo.findNormalUserByUsernameAndPassword(username, password);
        if(nu != null)
            return "HomePage";
        else
            return "normalLogin";
    }

    @PostMapping("/login1")
    public String loginSucc(
            @RequestParam("Username") String username,
            @RequestParam("password") String password) {
            return "HomePage";
    }


    /*@RequestMapping("/login?Username={val1}&password={val2}")
    public String loginSucc(@PathVariable String username , @PathVariable String pass)
    {
        return "HomePage";
    }*/
    @RequestMapping("/all")
    public @ResponseBody Iterable<NormalUser> getAllUsers() {
        // This returns a JSON or XML with the users
        Iterable<NormalUser> iu = normalRepo.findAll();
        return iu;
    }
}
