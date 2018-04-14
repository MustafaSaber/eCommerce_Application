package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
public interface CartRepository extends JpaRepository<Cart,Long> {
}
