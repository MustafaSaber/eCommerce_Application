package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.Cart;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mina_Yousry on 28/03/2018.
 */
public interface CartRepo extends CrudRepository<Cart, String> {
    public Cart findByOwner(String owner);
    public Cart findCartByOwner(String Owner);
    public Cart findByCartID(Integer id);
}
