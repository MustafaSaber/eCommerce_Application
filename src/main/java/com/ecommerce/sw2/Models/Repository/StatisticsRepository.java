package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics , Long> {

    Optional<Statistics> findById(Long id);
    Optional<Statistics> findByEntityAndAttributeAndFunction(String e , String a , String f);
}
