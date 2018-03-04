package com.ecommerce.sw2.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Model {
    @Id
    String name;
    String brand;
    int views;

    public Model(String name, String brand) {
        this.name = name;
        this.brand = brand;
        this.views = 0;
    }

    public Model() { views = 0; }

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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
