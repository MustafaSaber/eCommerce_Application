package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.SystemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */
public interface SystemModelRepository extends JpaRepository<SystemModel,Long> {
    Optional<SystemModel> findByName(String name);
}
