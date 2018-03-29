package com.ecommerce.sw2.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Model {
    @Id
    String name;

    @ManyToOne
    Brand brand;

    public Model(){
    }

    public Model(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
