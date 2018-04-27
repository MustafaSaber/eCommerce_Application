package com.ecommerce.sw2.Models.Domain;

import javax.persistence.*;

@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "entity" , nullable = false , updatable = false)
    private String entity;

    @Column(name = "attribute" , nullable = false , updatable = false)
    private String attribute;

    @Column(name = "function" , nullable = false , updatable = false)
    private String function;

    public Statistics() {
    }

    public Statistics(String entity, String attribute, String function) {
        this.entity = entity;
        this.attribute = attribute;
        this.function = function;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
