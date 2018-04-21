package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByOwnerId(Long id);
}
