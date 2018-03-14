package com.ecommerce.sw2.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Model {
    @Id
    String name;
    String brand;

    public Model(String name, String brand) {
        this.name = name;
        this.brand = brand;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
