package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Services.UserService;
//import com.ecommerce.sw2.auth.LoggedUser;
import com.ecommerce.sw2.forms.RegisterForm;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class LoginController {

    @Autowired
    private UserService userService;


    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public Optional<User> getLoginPage(HttpServletRequest request) {
        System.out.println("IM Here");
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        HttpSession session = request.getSession(true);
        System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Principal principal = request.getUserPrincipal();
        System.out.println(user.getUsername() + " IM NULL ");
        return userService.getUserByUsername(principal.getName());
    }*/

    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<User> login(Model model, String error) {

        System.out.println("LOGIN"+model.toString());

        if (error != null) {
            System.out.println("1.IF");
            model.addAttribute("error", "Your username and password is invalid.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new User());
    }*/


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(@RequestBody RegisterForm registerForm)
    {
        JSONObject jsonObject = new JSONObject();
        Optional<User> user =  userService.getUserByUsernameAndPassword(registerForm.getUsername() , registerForm.getPassword());
        if(user.isPresent())
        {
            jsonObject.put("username", user.get().getUsername());
            jsonObject.put("email", user.get().getEmail());
            jsonObject.put("name", user.get().getName());
            JSONArray array = new JSONArray();
            array.add(user.get().getRole());
            jsonObject.put("roles" , array);
            return jsonObject;
        }
        else return null;

    }

    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public Collection<User> getUsers()
    {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User register(@RequestBody RegisterForm RegisterForm)
    {
       return userService.create(RegisterForm);
    }


/*    @RequestMapping(value = "/create", method = RequestMethod.GET)
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
    }*/
}
