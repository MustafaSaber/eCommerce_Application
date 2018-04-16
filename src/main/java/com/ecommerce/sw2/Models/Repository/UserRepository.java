package com.ecommerce.sw2.Models.Repository;

import com.ecommerce.sw2.Models.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByUsername(String username);
    Optional<User> findOneByUsernameAndPasswordHash(String username , String password);
}
