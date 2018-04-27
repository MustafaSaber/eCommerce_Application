package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.forms.AddToCartForm;
import com.ecommerce.sw2.forms.RegisterForm;

import java.util.Collection;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
public interface CartService {

    Cart AddToCart(AddToCartForm addToCartForm);

    Cart CheckOut(Long id);
    Cart viewCart(RegisterForm registerForm);
}
