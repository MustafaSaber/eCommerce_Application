package com.ecommerce.sw2.Models;
import javax.persistence.*;

/**
 * Created by Mina_Yousry on 03/03/2018.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    private String name;
    private String Email;
    @Id
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String email, String username, String password) {
        this.name = name;
        Email = email;
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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
