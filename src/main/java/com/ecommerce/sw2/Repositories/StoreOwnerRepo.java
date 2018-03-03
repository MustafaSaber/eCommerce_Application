package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.StoreOwnerUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@Repository
public interface StoreOwnerRepo extends CrudRepository<StoreOwnerUser,String> {
}
