package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Brand getBrandByName(String name);
    Optional<Brand> findByName(String name);
}
