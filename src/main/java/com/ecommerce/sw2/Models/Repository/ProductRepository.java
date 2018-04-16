package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

    //Optional<Product> findOneByName(String name);
    Collection<Product> findByName(String name);
    Collection<Product> findByMystore_Id(Long id);
    Optional<Product> findById(Long id);
    Collection<Product> findAllById(Long id);
   // Collection<Product> find();
}
