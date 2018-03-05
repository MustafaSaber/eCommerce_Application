package com.ecommerce.sw2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@RequestMapping("/system")
@Controller
public class SystemController {
    @RequestMapping("")
    public String index(){
        return "index";
    }
    @RequestMapping("/Login")
    public String login() { return "normalLogin";}

    @RequestMapping("/adminRegister")
    String redirectadmin(){
        return "adminRegister";
    }
    @RequestMapping("/storeOwnerRegister")
    String redirectstoreOwner(){
        return "storeOwnerRegister";
    }
}
