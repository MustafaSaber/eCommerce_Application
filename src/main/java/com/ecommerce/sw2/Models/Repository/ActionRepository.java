package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Action;
import com.ecommerce.sw2.Models.Domain.ProductBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
}
