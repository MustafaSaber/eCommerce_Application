package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.Models.Repository.CartRepository;
import com.ecommerce.sw2.Models.Services.CartService;
import com.ecommerce.sw2.Validators.AddToCartFormValidator;
import com.ecommerce.sw2.forms.AddToCartForm;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
@RestController
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    AddToCartFormValidator addToCartFormValidator;

    @InitBinder("addToCartForm")
    public void AddToCartFormInitBinder(WebDataBinder binder) {
        binder.addValidators(addToCartFormValidator);
    }


    @RequestMapping(value = "/addtocart",method = RequestMethod.POST)
    public ResponseEntity<?> addtocart(@Valid @RequestBody AddToCartForm addToCartForm, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","null1");
            return ResponseEntity.ok().body(jsonObject);
        }
        return ResponseEntity.ok().body(cartService.AddToCart(addToCartForm));
    }


    @RequestMapping(value = "/checkout",method = RequestMethod.POST)
    public ResponseEntity<?> checkout(@RequestBody Long id)
    {
        Optional<Cart> cart = cartRepository.findById(id);
        if (!cart.isPresent()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "null");
            return ResponseEntity.ok().body(jsonObject);
        }
        return ResponseEntity.ok().body(cartService.CheckOut(id));
    }
}
