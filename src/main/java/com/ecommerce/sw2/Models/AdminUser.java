package com.ecommerce.sw2.Models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@Entity
public class AdminUser extends User{
    boolean confirmed;
    public AdminUser()
    {
        super();
        confirmed = false;
    }
    public AdminUser(String name,String email, String username, String password) {
        super(name,email,username,password);
        confirmed = false;
    }
}

