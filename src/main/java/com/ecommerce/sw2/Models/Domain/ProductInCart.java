package com.ecommerce.sw2.Models.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
@Entity
public class ProductInCart {
    @Id
    @Column(name = "id" , nullable = false , updatable = false)
    private Long id;

    @Column(name = "price" , nullable = false)
    private float price;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "no_of_items" , nullable = false)
    private int no_of_items;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Store mystore;

    @ManyToOne(optional = false)
    @JsonBackReference
    private SystemModel systemModel;


    public SystemModel getSystemModel() {
        return systemModel;
    }

    public void setSystemModel(SystemModel systemModel) {
        this.systemModel = systemModel;
    }

    public ProductInCart() {
    }

    public int getNo_of_items() {
        return no_of_items;
    }

    public void setNo_of_items(int no_of_items) {
        this.no_of_items = no_of_items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getMystore() {
        return mystore;
    }

    public void setMystore(Store mystore) {
        this.mystore = mystore;
    }

    public void equal(Product p,int q){
        this.id = p.getId();
        this.mystore = p.getMystore();
        this.price = p.getPrice();
        this.name = p.getName();
        this.no_of_items = q;//p.getNo_of_items()
        this.systemModel = p.getSystemModel();
    }
}
