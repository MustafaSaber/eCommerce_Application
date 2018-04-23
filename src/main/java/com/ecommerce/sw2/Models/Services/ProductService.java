package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.forms.AddProductForm;
import com.ecommerce.sw2.forms.EditProductForm;
import com.ecommerce.sw2.forms.RegisterForm;
import com.ecommerce.sw2.forms.StoreForm;
import org.springframework.security.core.parameters.P;

import java.util.Collection;

import java.util.Optional;

public interface ProductService {


    Optional<Product> getProduct(Long id);

    Product addProduct(AddProductForm addProductForm);

    Collection<Product> getProductsByStore(StoreForm form);

    Product edit(EditProductForm editProductForm);

    Collection<Product> viewProducts();

    Product viewproduct(Long id);

    Collection<Product> cartProducts(Long cartID);

    Product getBestSellerInStore(String storename);

    Product getMostViewedInStore(String storename);
}
