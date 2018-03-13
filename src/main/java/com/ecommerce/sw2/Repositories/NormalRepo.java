package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.NormalUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@Repository
public interface NormalRepo extends CrudRepository<NormalUser, String> {
    public NormalUser findNormalUserByUsernameAndPassword(String Name, String Pass);
}
