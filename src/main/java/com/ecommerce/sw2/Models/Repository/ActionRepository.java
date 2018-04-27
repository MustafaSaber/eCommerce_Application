package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    Optional<Action> findById(Long id);


}
