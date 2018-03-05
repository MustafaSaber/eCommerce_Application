package com.ecommerce.sw2.Models;

import javax.persistence.Entity;
import java.util.Vector;
@Entity
public class Store {
    String name;
    @javax.persistence.Id
    String storeID;
    Vector<Product> products = new Vector<>();

    public Store(String name, String storeID, Vector<Product> products) {
        this.name = name;
        this.storeID = storeID;
        this.products = products;
    }

    public Store() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public Vector<Product> getProducts() {
        return products;
    }

    public void setProducts(Vector<Product> products) {
        this.products = products;
    }
}
