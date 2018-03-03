package com.ecommerce.sw2.Models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@Entity
public class StoreOwnerUser extends User {
    public StoreOwnerUser()
    {
        super();
    }
    public StoreOwnerUser(String name,String email, String username, String password) {
        super(name,email,username,password);
    }
}
