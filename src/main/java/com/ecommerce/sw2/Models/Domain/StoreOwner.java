package com.ecommerce.sw2.Models.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
@Entity
public class StoreOwner {

    @Id
    protected Long id;

   // @JoinColumn(name = "ID")

    @MapsId
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @OneToMany(mappedBy = "storeOwner")
    private List<Store> stores;

    public List<Store> getStores() {
        return stores;
    }

    public StoreOwner() {
    }

    public StoreOwner(User user) {
        this.user = user;
    }

    public boolean addStore(Store store)
    {
        if(stores == null)
            stores = new ArrayList<>();
        return stores.add(store);
    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
*/