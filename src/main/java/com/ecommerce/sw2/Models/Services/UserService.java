package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.forms.RegisterForm;

import com.ecommerce.sw2.Models.Domain.*;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;
import java.util.Optional;

public interface UserService {

    //Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByUsernameAndPassword(String username , String password);

    Collection<User> getAllUsers();

    User create(RegisterForm form);
}