package com.ecommerce.sw2.Models.Domain;

import org.jboss.logging.Field;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */
@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;


    @Column(name = "name", nullable = false, updatable = true, unique = true)
    private String name;


    @OneToMany(mappedBy = "brand")
    private List<SystemModel> products;

    public Brand(){
    }

    public Brand(String name) {
        this.name = name;
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

    public List<SystemModel> getProducts() {
        return products;
    }

    public void setProducts(List<SystemModel> products) {
        this.products = products;
    }
}
