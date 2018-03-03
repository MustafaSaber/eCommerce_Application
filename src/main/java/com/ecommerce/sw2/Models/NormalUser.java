package com.ecommerce.sw2.Models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */

@Entity
public class NormalUser extends User {
    NormalUser() {
        super();
    }

    public NormalUser(String name, String email, String username, String password) {
        super(name, email, username, password);
    }
}
