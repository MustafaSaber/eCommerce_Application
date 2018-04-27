package com.ecommerce.sw2.Models.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "mystore")
    private List<Product> products;

    @ManyToOne(optional = false)
    @JsonBackReference
    private User storeOwner;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "collaboratedStores")
    protected Set<User> collaborators;

    @OneToMany
    private List<Action> actions;

    @OneToMany
    private List<Statistics> statistics;

    public Boolean AddStat(Statistics stat)
    {
        if(statistics == null) statistics = new ArrayList<>();
        return statistics.add(stat);
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public Boolean addAction(Action action)
    {
        if(actions ==  null) actions = new ArrayList<>();
        return actions.add(action);
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public Boolean addCollaborator(User user)
    {
        if(collaborators == null) collaborators = new HashSet<>();

        return collaborators.add(user);
    }

    public Set<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(Set<User> collaborators) {
        this.collaborators = collaborators;
    }

    public User getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(User storeOwner) {
        this.storeOwner = storeOwner;
    }

    public Store() {
        this.suggested = false;
        collaborators = new HashSet<>();
        actions = new ArrayList<>();
    }

    public Store(String name) {
        this.name = name;
        this.suggested = false;
        collaborators = new HashSet<>();
        actions = new ArrayList<>();
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean addproduct(Product product)
    {
        if(products == null)
            products = new ArrayList<>();
        return products.add(product);
    }

}
