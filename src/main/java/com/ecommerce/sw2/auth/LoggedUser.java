package com.ecommerce.sw2.auth;

import com.ecommerce.sw2.Models.Domain.Role;
import com.ecommerce.sw2.Models.Domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public LoggedUser(User user) {
        super(user.getUsername(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString(),"[" , "]"));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Collection<Role> getRole() {
        return user.getRole();
    }
}
