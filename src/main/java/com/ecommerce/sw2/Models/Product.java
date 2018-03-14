package com.ecommerce.sw2.Models;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = AUTO)
    Integer productID;

    String model;
    Double price;
    String store;
    String brand;
    Integer no_of_views;
    Integer no_of_sold_out;

    public Product( String model,
                   Double price, String store,
                   String brand, int no_of_views, int no_of_sold_out) {
        this.model = model;
        this.price = price;
        this.store = store;
        this.brand = brand;
        this.no_of_views = no_of_views;
        this.no_of_sold_out = no_of_sold_out;

    }

    public Product(){}
    public Product(String model, Double price, String store, String brand) {
        this.model = model;
        this.price = price;
        this.store = store;
        this.brand = brand;
        no_of_views = 0;
        no_of_sold_out = 0;
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

    public int getNo_of_views() {
        return no_of_views;
    }

    public void setNo_of_views(int no_of_views) {
        this.no_of_views = no_of_views;
    }

    public int getNo_of_sold_out() {
        return no_of_sold_out;
    }

    public void setNo_of_sold_out(int no_of_sold_out) {
        this.no_of_sold_out = no_of_sold_out;
    }

}
