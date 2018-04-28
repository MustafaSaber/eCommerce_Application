package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Cart;
import com.ecommerce.sw2.Models.Domain.Role;
import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Repository.CartRepository;
import com.ecommerce.sw2.Models.Repository.UserRepository;
import com.ecommerce.sw2.forms.RegisterForm;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

/**
 * Created by Mina_Yousry on 26/04/2018.
 */
@Test
public class UserServiceImpTest extends AbstractTestNGSpringContextTests {

   //private static Logger logger = Logger.getLogger(UserServiceImpTest.class);

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    UserServiceImp userServiceImp;

    @Mock
    UserRepository userRepository;

    @Mock
    CartRepository cartRepository;

    @Test
    public void testGetUserByEmail() throws Exception {
    }

    @Test
    public void testGetUserByUsername() throws Exception {
    }

    @Test
    public void testGetUserByUsernameAndPassword() throws Exception {
    }

    @Test
    public void testGetAllUsers() throws Exception {
    }

    @Test
    public void testCreate() throws Exception {
        String name = "name";
        String email= "email";
        String username ="username";
        String password = "password";
        RegisterForm registerForm = new RegisterForm(name,email,username,password);


        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        User user = spy(new User(name,email,username,password,roleSet));
        Cart cart = spy(new Cart(user));

        when(userRepository.findOneByUsername(username)).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(user);
        when(cartRepository.save(any())).thenReturn(cart);

        assertEquals(user,userServiceImp.create(registerForm));
    }


    @Test
    public void testCreate1() throws Exception {
        // String repeated username;;;

        String name = "name";
        String email= "email";
        String username ="username";
        String password = "password";
        RegisterForm registerForm = new RegisterForm(name,email,username,password);


        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        User user = spy(new User(name,email,username,password,roleSet));
        Cart cart = spy(new Cart(user));

        when(userRepository.findOneByUsername(username)).thenReturn(Optional.of(user));
        when(userRepository.save(any())).thenReturn(user);
        when(cartRepository.save(any())).thenReturn(cart);

        assertEquals(null,userServiceImp.create(registerForm));
    }

    @Test
    public void testCreate2() throws Exception {
        String name = "name";
        String email= "email";/// email existed....
        String username ="username";
        String password = "password";
        RegisterForm registerForm = new RegisterForm(name,email,username,password);


        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        User user = spy(new User(name,email,username,password,roleSet));
        Cart cart = spy(new Cart(user));

        when(userRepository.findOneByUsername(username)).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(null);
        when(cartRepository.save(any())).thenReturn(cart);

        assertEquals(null,userServiceImp.create(registerForm));
    }



    @Test
    public void testCheckAdmin() throws Exception {
        String name = "name";
        String email= "email";/// email existed....
        String username ="username";
        String password = "password";
        RegisterForm registerForm = new RegisterForm(name,email,username,password);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        User user = spy(new User(name,email,username,password,roleSet));
        when(userServiceImp.getUserByUsername(username)).thenReturn(Optional.of(user));
        assertEquals(true,userServiceImp.checkAdminn(registerForm));
    }

    @Test
    public void testCheckAdmin1() throws Exception {
        String name = "name";
        String email= "email";/// email existed....
        String username ="username";
        String password = "password";
        RegisterForm registerForm = new RegisterForm(name,email,username,password);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = spy(new User(name,email,username,password,roleSet));
        when(userServiceImp.getUserByUsername(username)).thenReturn(Optional.of(user));
        assertEquals(false,userServiceImp.checkAdminn(registerForm));
    }


}
