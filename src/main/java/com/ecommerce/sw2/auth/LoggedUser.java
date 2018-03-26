package com.ecommerce.sw2.auth;

import com.ecommerce.sw2.Models.Domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public LoggedUser(User user) {
        super(user.getUsername(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return user.getId();
    }

    public String getRole() {
        return user.getRole();
    }
}
