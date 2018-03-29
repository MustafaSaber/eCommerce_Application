package com.ecommerce.sw2.Models;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Mina_Yousry on 28/03/2018.
 */

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer cartID;

    @OneToMany
    private Set<Product> products;

    //    @OneToOne
//    @PrimaryKeyJoinColumn
    private String owner;

    private Double total_price;

    public Cart() {
    }

    public Cart(String owner) {
        products = new HashSet<>();
        this.owner = owner;
        total_price = 0.0;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Integer getCartID() {
        return cartID;
    }

    public void AddProduct(Product product) {
        if (products.add(product))
            total_price += product.getPrice();
    }

    public void setCartID(Integer cartID) {
        this.cartID = cartID;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean removeProduct(Integer id) {
        Iterator<Product> i = products.iterator();
        while (i.hasNext()) {
            Product p = i.next();
            if (p.getProductID().equals(id)) {
                total_price-=p.getPrice();
                i.remove();
                return true;
            }
        }
        return false;
    }
}