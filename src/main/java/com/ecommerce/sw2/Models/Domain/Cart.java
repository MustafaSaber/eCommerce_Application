package com.ecommerce.sw2.Models.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.*;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long cartID;

    @OneToMany
    @JsonBackReference
    @Cascade(CascadeType.ALL)
    private Set<ProductInCart> products;

    @OneToOne
    @JsonManagedReference
    private User owner;

    private Integer discount;

    private Double total_price;

    public Cart(){
        total_price = 0.0;
        discount = 15;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Cart(User owner) {
        this.owner = owner;
        total_price = 0.0;
        products = new HashSet<>();
        discount = 15;
    }

    public Boolean addProduct(ProductInCart productInCart)
    {
        if(products == null) products = new HashSet<>();
        return products.add(productInCart);
    }

    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public Set<ProductInCart> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductInCart> products) {
        this.products = products;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }
}
