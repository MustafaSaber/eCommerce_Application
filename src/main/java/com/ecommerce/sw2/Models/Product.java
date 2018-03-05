package com.ecommerce.sw2.Models;

import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayGetAtMetaMethod;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Product {
    @javax.persistence.Id
    Integer productID;

    String model;
    Double price;
    String store;
    String brand;

    public Product(){}
    public Product(Integer productID, String model, Double price, String store, String brand) {
        this.productID = productID;
        this.model = model;
        this.price = price;
        this.store = store;
        this.brand = brand;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
