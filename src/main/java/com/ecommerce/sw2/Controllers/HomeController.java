package com.ecommerce.sw2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
        @RequestMapping("/")
        ModelAndView Index() {
            return new ModelAndView("home/index");
        }

}
