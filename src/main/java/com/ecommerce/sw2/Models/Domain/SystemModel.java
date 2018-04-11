package com.ecommerce.sw2.Models.Domain;

import javax.persistence.*;

@Entity
@Table(name = "systemmodel")
public class SystemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , nullable = false , updatable = false)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @ManyToOne
    private Brand brand;

    /*
    * We need to map our logic in adding products to store
    * despite we have to make model or not.*/
    //THINK

    public SystemModel () {
        this.name = "";
    }

    public SystemModel(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}