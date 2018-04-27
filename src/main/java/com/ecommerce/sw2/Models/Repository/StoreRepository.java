package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findOneByName(String name);
    Collection<Store> findAllBySuggested(Boolean check);
    Optional<Store> findStoreById(Long id);
    Collection<Store> findByStoreOwner_Id(Long id);
    Collection<Store> findByStoreOwner_IdAndAndSuggested(Long id , boolean check);
    Collection<Store> findBySuggested(boolean check);
}
