package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Domain.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
@Repository
public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
    Optional<ProductInCart> findById(Long id);
    Optional<ProductInCart> findByCartAndAndId(Long cid,Long id);
    Optional<ProductInCart> findByProduct_IdAndCart_CartID(Long id,Long cid);
}
