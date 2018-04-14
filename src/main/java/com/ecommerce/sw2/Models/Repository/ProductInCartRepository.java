package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Domain.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
    Optional<ProductInCart> findById(Long id);
}
