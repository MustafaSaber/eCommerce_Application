package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Domain.ProductInCart;
import com.ecommerce.sw2.Models.Repository.CartRepository;
import com.ecommerce.sw2.Models.Repository.ProductInCartRepository;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.forms.AddToCartForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
@Service
public class CartServiceImp implements CartService {
    @Autowired
    ProductService productService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductInCartRepository productInCartRepository;

    @Override
    public Cart AddToCart(AddToCartForm addToCartForm) {
        Optional<Product> product = productService.getProduct(addToCartForm.getProductid());
        Optional<Cart> cart = cartRepository.findById(addToCartForm.getCartid());
        if (!cart.isPresent())
            return null;
        if (!product.isPresent())
            return cart.get();
        if (addToCartForm.getQuantity() <= 0)
            return cart.get();

        Optional<ProductInCart> productInCart = productInCartRepository.findById(addToCartForm.getProductid());
        if (!productInCart.isPresent()) {
            productInCart = Optional.of(new ProductInCart());
            productInCart.get().equal(product.get(), addToCartForm.getQuantity());
            cart.get().setTotal_price(cart.get().getTotal_price() +
                    productInCart.get().getPrice()*addToCartForm.getQuantity());
        }
        else if (productInCart.get().getNo_of_items() + addToCartForm.getQuantity() <= product.get().getNo_of_items()) {
            productInCart.get().setNo_of_items(productInCart.get().getNo_of_items()
                    + addToCartForm.getQuantity() );
            cart.get().setTotal_price(cart.get().getTotal_price() +
                    productInCart.get().getPrice()*addToCartForm.getQuantity());
        }
        else{
            return cart.get();
        }

        cart.get().getProducts().add(productInCartRepository.save(productInCart.get()));
        return cartRepository.save(cart.get());
    }

    @Override
    public Cart CheckOut(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (!cart.isPresent())
            return null;
        for (ProductInCart p : cart.get().getProducts()) {
            int Quantity = p.getNo_of_items();
            Optional<Product> product = productService.getProduct(p.getId());
            if (!product.isPresent())
                return cart.get();
            if (product.get().getNo_of_items() < Quantity)
                return cart.get();
            else
            {
                product.get().setNo_of_items(product.get().getNo_of_items()-Quantity);
                product.get().setSold(product.get().getSold()+Quantity);
                productRepository.save(product.get());
                productInCartRepository.delete(p);
            }
        }
        cart.get().setProducts(new HashSet<>());
        cart.get().setTotal_price(0.0);
        return cartRepository.save(cart.get());
    }
}
