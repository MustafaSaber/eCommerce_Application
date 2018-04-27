package com.ecommerce.sw2.forms;

import javax.validation.constraints.NotEmpty;

public class RegisterForm {

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String username = "";

    @NotEmpty
    private String password = "";

    public RegisterForm() {
    }

    public RegisterForm(@NotEmpty String name, @NotEmpty String email, @NotEmpty String username, @NotEmpty String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
