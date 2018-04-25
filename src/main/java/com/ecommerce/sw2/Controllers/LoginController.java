package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Repository.UserRepository;
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
import javax.persistence.EntityManager;
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

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Optional<User> login(@RequestBody RegisterForm registerForm)
    {
        Optional<User> user =  userService.getUserByUsernameAndPassword(registerForm.getUsername() , registerForm.getPassword());
        if(user != null) {
            User form = new User();
            form.setName(user.get().getName());
            form.setEmail(user.get().getEmail());
            form.setUsername(user.get().getUsername());
            form.setPasswordHash(user.get().getPasswordHash());
            return Optional.ofNullable(form);
        }
        return user;
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


    @RequestMapping(value = "/checkAdmin", method = RequestMethod.POST)
    public boolean checkAdmin(@RequestBody RegisterForm RegisterForm)
    {
        return userService.checkAdminn(RegisterForm);
    }

}
