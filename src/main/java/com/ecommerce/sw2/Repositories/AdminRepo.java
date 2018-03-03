package com.ecommerce.sw2.Repositories;

import com.ecommerce.sw2.Models.AdminUser;
import com.ecommerce.sw2.Models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
public interface AdminRepo extends CrudRepository<AdminUser, String> {
}
