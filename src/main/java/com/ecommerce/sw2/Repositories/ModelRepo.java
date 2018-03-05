package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepo extends CrudRepository<Model, String> {

}
