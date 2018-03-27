package com.ecommerce.sw2.Models.Domain;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , nullable = false , updatable = false)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;


    @Column(name = "ave_price" , nullable = false)
    private Float averagePrice;


    /*
    * We need to map our logic in adding products to store
    * despite we have to make model or not.*/
    //THINK

    public Product () {
        this.name = "";
        this.averagePrice = 0f;
    }

    public Product(String name, Float averagePrice) {
        this.name = name;
        this.averagePrice = averagePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Float averagePrice) {
        this.averagePrice = averagePrice;
    }
}
