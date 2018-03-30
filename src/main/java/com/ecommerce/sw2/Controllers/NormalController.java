package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.NormalUser;
import com.ecommerce.sw2.Models.StoreOwnerUser;
import com.ecommerce.sw2.Models.User;
import com.ecommerce.sw2.Repositories.NormalRepo;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//import javax.validation.constraints.Null;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@RequestMapping("/normal")
@Controller
@SessionAttributes("User")
public class NormalController {
    @Autowired
    private NormalRepo normalRepo;

    @Autowired
    private SystemController systemController;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addNewUser(Model model){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser (
            @RequestParam("Name") String name
            , @RequestParam("Email") String email
            , @RequestParam("Username") String username
            , @RequestParam("password") String password, Model model) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        NormalUser n = new NormalUser(name , email , username , password);
        if (normalRepo.existsById(username))
            return "index";
        normalRepo.save(n);
        return "Saved";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model)
    {
        return "normalLogin";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(
            @RequestParam("Username") String username,
            @RequestParam("password") String password, Model model) {
        NormalUser nu =normalRepo.findNormalUserByUsernameAndPassword(username, password);
        if(nu != null) {
            if(!model.containsAttribute("User")) {
                model.addAttribute("User" , new NormalUser(nu.getName(), nu.getEmail() , nu.getUsername() , ""));
//                return new ModelAndView(systemController.index(model),
//                        "User",new NormalUser(nu.getName(), nu.getEmail() , nu.getUsername() , ""));
                return "redirect:/";
            }
            else
                return "redirect:/index";
        }
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
