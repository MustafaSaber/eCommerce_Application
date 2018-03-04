package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product , Integer> {

}
