package com.ecommerce.sw2.Controllers;
import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.Models.Repository.CartRepository;
import com.ecommerce.sw2.Models.Services.CartService;
import com.ecommerce.sw2.Validators.AddToCartFormValidator;
import com.ecommerce.sw2.forms.AddToCartForm;
import com.ecommerce.sw2.forms.RegisterForm;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

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
            jsonObject.put("name","null");
            return ResponseEntity.ok().body(jsonObject);
        }
        Cart cart = cartService.AddToCart(addToCartForm);
        if (cart == null)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","null");
            return ResponseEntity.ok().body(jsonObject);
        }
        return ResponseEntity.ok().body(cart);
    }

    @RequestMapping(value = "/checkout/{mycart}",method = RequestMethod.GET)
    public ResponseEntity<?> checkout(@PathVariable Long mycart)
    {
        Optional<Cart> cart = cartRepository.findById(mycart);
        if (!cart.isPresent()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "null");
            return ResponseEntity.ok().body(jsonObject);
        }
        return ResponseEntity.ok().body(cartService.CheckOut(mycart));
    }
    @RequestMapping(value = "/viewcart",method = RequestMethod.POST)
    public ResponseEntity<?> viewCart(@RequestBody RegisterForm registerForm)
    {
        Cart cart = cartService.viewCart(registerForm);
        if (cart == null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","null");
            return ResponseEntity.ok().body(jsonObject);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",cart.getOwner());
        jsonObject.put("CartID",cart.getCartID());
        jsonObject.put("Products",cart.getProducts());
        jsonObject.put("price",cart.getTotal_price());
        return ResponseEntity.ok().body(jsonObject);
    }
}