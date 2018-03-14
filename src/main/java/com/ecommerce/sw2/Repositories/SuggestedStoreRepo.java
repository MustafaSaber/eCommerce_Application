package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.SuggestedStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.util.Vector;

@Repository
public interface SuggestedStoreRepo extends CrudRepository<SuggestedStore, String> {

    public void deleteByNameAndStoreOwner(String name , String StoreOwner);

    public SuggestedStore findByNameAndStoreOwner(String name , String StoreOwner);

}
