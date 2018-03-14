package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.Product;
import com.ecommerce.sw2.Models.Store;
import com.ecommerce.sw2.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

/**
 * Created by Mina_Yousry on 14/03/2018.
 */
@Repository
public interface StoreRepo extends CrudRepository<Store, String> {
    public Vector<Store> findByStoreOwner(String id);
    public  Store findByNameAndAndStoreOwner(String name , String so);
}
