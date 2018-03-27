package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Services.UserService;
import com.ecommerce.sw2.forms.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login/login", "error", error.isPresent() ? error : null);
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView register(@ModelAttribute("registerForm") RegisterForm RegisterForm) {

        return new ModelAndView("login/create", "registerForm", RegisterForm);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute("registerForm") RegisterForm RegisterForm, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors())
            return new ModelAndView("login/create", "registerForm", RegisterForm);


        userService.create(RegisterForm);

        try {
            //request.changeSessionId();
            request.login(RegisterForm.getUsername(), RegisterForm.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return new ModelAndView("redirect:/");
    }
}
