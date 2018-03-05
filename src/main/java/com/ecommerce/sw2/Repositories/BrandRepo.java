package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends CrudRepository<Brand, String> {
}
