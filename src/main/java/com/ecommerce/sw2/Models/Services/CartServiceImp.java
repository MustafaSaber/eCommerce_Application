package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Domain.ProductInCart;
import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Repository.CartRepository;
import com.ecommerce.sw2.Models.Repository.ProductInCartRepository;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Repository.UserRepository;
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
    @Autowired
    UserRepository userRepository;

    @Override
    public Cart AddToCart(AddToCartForm addToCartForm) {
        Optional<Product> product = productService.getProduct(addToCartForm.getProductid());
        Optional<User> user = userRepository.findOneByUsername(addToCartForm.getUsername());
        Optional<Cart> cart = cartRepository.findById(user.get().getCart().getCartID());
        if (!cart.isPresent())
            return null;
        if (!product.isPresent())
            return null;
        if (addToCartForm.getQuantity() <= 0)
            return null;

        Optional<ProductInCart> productInCart = productInCartRepository.findByProduct_IdAndCart_CartID
                (addToCartForm.getProductid(),cart.get().getCartID());

        if (!productInCart.isPresent()) {
            productInCart = Optional.of(new ProductInCart());
            productInCart.get().equal(product.get(), addToCartForm.getQuantity(),cart.get());
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
            return null;
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
            Optional<Product> product = productService.getProduct(p.getProduct().getId());
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
