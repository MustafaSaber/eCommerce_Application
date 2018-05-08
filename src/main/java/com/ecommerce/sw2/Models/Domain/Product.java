package com.ecommerce.sw2.Models.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , nullable = false , updatable = false)
    private Long id;


    @Column(name = "price" , nullable = false)
    private float price;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "views", nullable = false)
    private int view;

    @Column(name = "no_of_sold" , nullable = false)
    private int sold;

    @Column(name = "no_of_items" , nullable = false)
    private int no_of_items;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Store mystore;

    @ManyToOne(optional = false)
    @JsonBackReference
    private SystemModel systemModel;

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public SystemModel getSystemModel() {
        return systemModel;
    }

    public void setSystemModel(SystemModel systemModel) {
        this.systemModel = systemModel;
    }

    public Product() {
        this.view = 0;
        this.sold = 0;
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

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Store getMystore() {
        return mystore;
    }

    public void setMystore(Store mystore) {
        this.mystore = mystore;
    }

    public void equal(Product p){
        this.mystore = p.mystore;
        this.price = p.price;
        this.name = p.name;
        this.no_of_items = p.no_of_items;
        this.systemModel = p.systemModel;
        this.view = p.view;
        this.sold = p.sold;
    }
}
