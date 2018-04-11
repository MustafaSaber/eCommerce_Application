package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Services.BrandService;
import com.ecommerce.sw2.Validators.AddBrandFormValidators;
import com.ecommerce.sw2.forms.AddBrandForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */


@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private AddBrandFormValidators addBrandFormValidators;

    @InitBinder("addBrandForm")
    public void AddBrandFormInitBinder(WebDataBinder binder) {
        binder.addValidators(addBrandFormValidators);
    }


    @RequestMapping(value = "/addbrand", method = RequestMethod.POST)
    public ResponseEntity<?> addbrand(@Valid @RequestBody AddBrandForm addBrandForm, BindingResult error)
    {
        System.out.println("Here");
        if(error.hasErrors()) {
            return ResponseEntity.badRequest().body(error.getAllErrors());
        }
        return ResponseEntity.ok(brandService.AddBrand(addBrandForm));
    }
}
