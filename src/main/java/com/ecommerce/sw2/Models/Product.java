package com.ecommerce.sw2.Models;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = AUTO)
    private Integer productID;

    @ManyToOne
    private Model model;

    private Double price;

    @ManyToOne
    private Store  store;

    @ManyToOne
    private Brand brand;

    private Integer no_of_views;
    private Integer no_of_sold_out;

    public Product( Model model,
                   Double price, Store store,
                   Brand brand, int no_of_views, int no_of_sold_out) {
        this.model = model;
        this.price = price;
        this.store = store;
        this.brand = brand;
        this.no_of_views = no_of_views;
        this.no_of_sold_out = no_of_sold_out;

    }

    public Product(){}
    public Product(Model model, Double price, Store store, Brand brand) {
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
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
