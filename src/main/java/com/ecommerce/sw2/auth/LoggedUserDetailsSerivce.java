package com.ecommerce.sw2.auth;

import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoggedUserDetailsSerivce implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public LoggedUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("username not found."));
        System.out.println(user.getUsername() + "   /////   " + user.getPasswordHash());
        return new LoggedUser(user);
    }
}