package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product , Long> {

    //Optional<Product> findOneByName(String name);
    Collection<Product> findByName(String name);
}
