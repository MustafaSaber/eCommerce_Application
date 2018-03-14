package com.ecommerce.sw2.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Vector;
@Entity
public class Brand {
    @Id
    String name;

    public Brand() { }
    public Brand(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}