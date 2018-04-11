package com.ecommerce.sw2.Models.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , nullable = false , updatable = false)
    private Long id;

    @Column(name = "name" , nullable = false , unique = true)
    private String name;

    @Column(name = "accepted")
    private Boolean suggested;

    @ManyToOne(optional = false)
    @JsonBackReference
    private StoreOwner storeOwner;

    public Store() {
        this.suggested = false;
    }

    public Store(String name) {
        this.name = name;
        this.suggested = false;
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

    public Boolean getSuggested() {
        return suggested;
    }

    public void setSuggested(Boolean suggested) {
        this.suggested = suggested;
    }
}
