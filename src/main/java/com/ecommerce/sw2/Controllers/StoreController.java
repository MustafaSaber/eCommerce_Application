package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Domain.Role;
import com.ecommerce.sw2.Models.Domain.Store;
//import com.ecommerce.sw2.Models.Domain.StoreOwner;
import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Repository.UserRepository;
import com.ecommerce.sw2.Models.Services.StoreService;
import com.ecommerce.sw2.Models.Services.UserService;
import com.ecommerce.sw2.Validators.StoreFormValidator;
import com.ecommerce.sw2.forms.RegisterForm;
import com.ecommerce.sw2.forms.StoreForm;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private UserService userService;

    @Autowired
    private StoreFormValidator storeFormValidator;


    @InitBinder("storeForm")
    public void StoreFormInitBinder(WebDataBinder binder) {
        binder.addValidators(storeFormValidator);
    }

    @RequestMapping(value = "/addstore" , method = RequestMethod.POST)
    public ResponseEntity<?> addstore(@Valid @RequestBody StoreForm storeForm , BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());


        Store store = storeService.createStore(storeForm);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", store.getId());
        jsonObject.put("name", store.getName());
        return ResponseEntity.ok().body(jsonObject);
    }

    @RequestMapping(value = "/approvestore",method = RequestMethod.POST)
    public ResponseEntity<?> approvestore(@RequestBody StoreForm storeForm)
    {
//        Long i = Long.getLong(id);
        Store s = storeService.acceptStore(storeForm.getName());
        if (s == null)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","null");
            return ResponseEntity.ok().body(jsonObject);
        }
        return ResponseEntity.ok().body(s);
    }

    @RequestMapping(value = "/getstores", method = RequestMethod.POST)
    public Collection<Store> getStoresStoreOwner(@RequestBody RegisterForm RegisterForm)
    {
        return storeService.getStoresforStoreOwner(RegisterForm);
    }

    @RequestMapping(value = "/getappstores", method = RequestMethod.POST)
    public Collection<Store> getStoresAdmin(@RequestBody RegisterForm RegisterForm)
    {
        return storeService.getStoresforAdmin(RegisterForm);
    }


}