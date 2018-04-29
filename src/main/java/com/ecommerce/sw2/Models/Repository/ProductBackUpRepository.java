package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.ProductBackup;
import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mina_Yousry on 15/04/2018.
 */
@Repository
public interface ProductBackUpRepository extends JpaRepository<ProductBackup, Long> {
    void deleteAllByPid(Long id);
    List<ProductBackup> findAllByPid(Long productid);
}
