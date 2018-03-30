package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
public interface ProductRepo extends CrudRepository<Product , Integer> {
    public Product findByProductID(Integer id);
    public Vector<Product> findByStore(String id);
    public Vector<Product> findByModel_NameAndStoreName(String model,String stname);
}
