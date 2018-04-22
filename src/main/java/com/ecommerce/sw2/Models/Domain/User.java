package com.ecommerce.sw2.Models.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "userRoles", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    /*@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private StoreOwner storeOwner;
    */

    @OneToOne
    @JsonBackReference
    private Cart cart;

    @OneToMany(mappedBy = "storeOwner")
    private List<Store> stores;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Store> collaboratedStores;

    public User(){}

    public User(String email, String passwordHash, String name, String username, Set<Role> roles) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.name = name;
        this.username = username;
        this.roles = roles;
        this.cart = new Cart(this);
    }

    public Boolean AddCollaboratedStore (Store store)
    {
        if(collaboratedStores == null) collaboratedStores = new HashSet<>();
        return collaboratedStores.add(store);
    }

    public Set<Store> getCollaboratedStores() {
        return collaboratedStores;
    }

    public void setCollaboratedStores(Set<Store> collaboratedStores) {
        this.collaboratedStores = collaboratedStores;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRole() {
        return roles;
    }

    public void setRole(Set<Role> role) {
        this.roles = role;
    }

    public void addRole(Role role)
    {
        if(roles == null) roles = new HashSet<>();
        roles.add(role);
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public boolean addstore(Store store)
    {
       //if(!roles.contains(Role.STORE_OWNER)) return false;

        if(stores == null)
            stores = new ArrayList<>();
        return stores.add(store);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
