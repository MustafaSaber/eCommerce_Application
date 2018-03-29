package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Product;
import com.ecommerce.sw2.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Vector;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */

@Controller
@SessionAttributes("User")
public class SystemController {
    @Autowired
    ProductRepo productRepo;

    @RequestMapping("")
    public String index(Model model){
        Iterable<Product> vp = productRepo.findAll();
        model.addAttribute("rows",vp);
        return "index";
    }
    @RequestMapping("/Login")
    public String login() { return "normalLogin";}

    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        if(model.containsAttribute("User")) model.asMap().remove("User");
        return index(model);
    }

    @RequestMapping("/adminRegister")
    String redirectadmin(){
        return "adminRegister";
    }
    @RequestMapping("/storeOwnerRegister")
    String redirectstoreOwner(){
        return "storeOwnerRegister";
    }


    @RequestMapping("/addproduct")
    public String renderAddProduct(){
        return "AddProduct";
    }
}
