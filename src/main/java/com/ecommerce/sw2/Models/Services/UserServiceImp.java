package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.Models.Domain.Role;
import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Repository.CartRepository;
import com.ecommerce.sw2.Models.Repository.UserRepository;
import com.ecommerce.sw2.forms.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    @Override
    public Optional<User> getUserByUsernameAndPassword(String username , String password) {
        return userRepository.findOneByUsernameAndPasswordHash(username , password);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User create(RegisterForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setUsername(form.getUsername());
        user.setPasswordHash(form.getPassword());
        //System.out.println(user.getPasswordHash() + " loknaspd " + form.getPassword());
        Optional<User> tempuser = userRepository.findOneByUsername(form.getUsername());
        if(tempuser.isPresent()) return null;
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        user.setRole(roles);
        Cart cart = new Cart();
        cart = cartRepository.save(cart);
        user.setCart(cart);
        return userRepository.save(user);
    }

    public boolean checkAdminn(RegisterForm form)
    {
        Optional<User> user = getUserByUsername(form.getUsername());

        for(Role role : user.get().getRole())
            if(role == Role.ADMIN)
                return true;

        return false;
    }
}
