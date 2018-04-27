package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Role;
import com.ecommerce.sw2.Models.Domain.Store;
import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Repository.StoreRepository;
import com.ecommerce.sw2.Models.Repository.UserRepository;
import com.ecommerce.sw2.forms.RegisterForm;
import com.ecommerce.sw2.forms.StoreForm;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

/**
 * Created by Mina_Yousry on 27/04/2018.
 */
@Test
public class StoreServiceImpTest extends AbstractTestNGSpringContextTests {

    @BeforeTest
    void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    StoreServiceImp storeServiceImp;

    @Mock
    UserRepository userRepository;

    @Mock
    StoreRepository storeRepository;

    @Mock
    UserService userService;

    @Test
    public void testCreateStore() throws Exception {
        // user is not store owner...
        String name = "name";
        String username = "username";
        StoreForm storeForm = new StoreForm();
        storeForm.setName(name);
        storeForm.setStore_owner_name(username);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        User user = new User("","","",username,roleSet);
        Store store = new Store(name);

        when(userRepository.findOneByUsername(username)).thenReturn(Optional.of(user));
        when(userRepository.save(any())).thenReturn(user);
        when(storeRepository.save(any())).thenReturn(store);

        assertEquals(store,storeServiceImp.createStore(storeForm));
    }

    @Test
    public void testCreateStore1() throws Exception {
        // user is store owner
        String name = "name";
        String username = "username";
        StoreForm storeForm = new StoreForm();
        storeForm.setName(name);
        storeForm.setStore_owner_name(username);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        roleSet.add(Role.STORE_OWNER);
        User user = new User("","","",username,roleSet);
        Store store = new Store(name);

        when(userRepository.findOneByUsername(username)).thenReturn(Optional.of(user));
        when(userRepository.save(any())).thenReturn(user);
        when(storeRepository.save(any())).thenReturn(store);

        assertEquals(store,storeServiceImp.createStore(storeForm));
    }

    @Test
    public void testCreateStore2() throws Exception {
        // user doesn't existed...
        String name = "name";
        String username = "username";
        StoreForm storeForm = new StoreForm();
        storeForm.setName(name);
        storeForm.setStore_owner_name(username);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        roleSet.add(Role.STORE_OWNER);
        User user = new User("","","",username,roleSet);
        Store store = new Store(name);

        when(userRepository.findOneByUsername(username)).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(user);
        when(storeRepository.save(any())).thenReturn(store);

        assertEquals(null,storeServiceImp.createStore(storeForm));
    }

    @Test
    public void testCreateStore3() throws Exception {
        // store name exist
        String name = "name";
        String username = "username";
        StoreForm storeForm = new StoreForm();
        storeForm.setName(name);
        storeForm.setStore_owner_name(username);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        roleSet.add(Role.STORE_OWNER);
        User user = new User("","","",username,roleSet);
        Store store = new Store(name);

        when(userRepository.findOneByUsername(username)).thenReturn(Optional.of(user));
        when(userRepository.save(any())).thenReturn(user);
        when(storeRepository.save(any())).thenReturn(null);

        assertEquals(null,storeServiceImp.createStore(storeForm));
    }



    @Test
    public void testAcceptStore() throws Exception {
        // store exist and not accepted
        String name = "name";
        Store store = new Store(name);
        when(storeRepository.findOneByName(name)).thenReturn(Optional.of(store));
        when(storeRepository.save(any())).thenReturn(store);

        assertEquals(store,storeServiceImp.acceptStore(name));
    }

    @Test
    public void testAcceptStore1() throws Exception {
        // store exist and accepted
        String name = "name";
        Store store = new Store(name);
        store.setSuggested(true);
        when(storeRepository.findOneByName(name)).thenReturn(Optional.of(store));
        when(storeRepository.save(any())).thenReturn(store);

        assertEquals(store,storeServiceImp.acceptStore(name));
    }

    @Test
    public void testAcceptStore2() throws Exception {
        // store doesn't exist
        String name = "name";
        Store store = new Store(name);
        when(storeRepository.findOneByName(name)).thenReturn(Optional.empty());
        when(storeRepository.save(any())).thenReturn(store);

        assertEquals(null,storeServiceImp.acceptStore(name));
    }

    @Test
    public void testAddcollab() throws Exception {
        // store exist, user exist and not collabrated, not store owner
        String name = "storename";
        String username = "username";

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        User user = new User("","","",username,roleSet);
        Store store = new Store(name);

        when(userService.getUserByUsername(username)).thenReturn(Optional.of(user));
        when(storeServiceImp.getStoreByName(name)).thenReturn(Optional.of(store));

        when(storeRepository.save(any())).thenReturn(store);
        when(userRepository.save(any())).thenReturn(user);

        assertEquals(user,storeServiceImp.addcollab(username,name));
    }

    @Test
    public void testAddcollab1() throws Exception {
        //store deoesn't exist
        String name = "storename";
        String username = "username";

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        roleSet.add(Role.STORE_OWNER);
        User user = new User("","","",username,roleSet);
        Store store = new Store(name);

        when(userService.getUserByUsername(username)).thenReturn(Optional.of(user));
        when(storeServiceImp.getStoreByName(name)).thenReturn(Optional.empty());

        when(storeRepository.save(any())).thenReturn(store);
        when(userRepository.save(any())).thenReturn(user);

        assertEquals(null,storeServiceImp.addcollab(username,name));
    }

    @Test
    public void testAddcollab2() throws Exception {
        //user deoesn't exist
        String name = "storename";
        String username = "username";

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        roleSet.add(Role.STORE_OWNER);
        User user = new User("","","",username,roleSet);
        Store store = new Store(name);

        when(userService.getUserByUsername(username)).thenReturn(Optional.empty());
        when(storeServiceImp.getStoreByName(name)).thenReturn(Optional.of(store));

        when(storeRepository.save(any())).thenReturn(store);
        when(userRepository.save(any())).thenReturn(user);

        assertEquals(null,storeServiceImp.addcollab(username,name));
    }

    @Test
    public void testAddcollab3() throws Exception {
        //user is already collabrated to this store..
        String name = "storename";
        String username = "username";

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        roleSet.add(Role.STORE_OWNER);
        User user = new User("","","",username,roleSet);
        Store store = new Store(name);
        user.AddCollaboratedStore(store);

        when(userService.getUserByUsername(username)).thenReturn(Optional.of(user));
        when(storeServiceImp.getStoreByName(name)).thenReturn(Optional.of(store));

        when(storeRepository.save(any())).thenReturn(store);
        when(userRepository.save(any())).thenReturn(user);

        assertEquals(null,storeServiceImp.addcollab(username,name));
    }

    @Test
    public void testAddcollab4() throws Exception {
        //user is storeowner
        String name = "storename";
        String username = "username";

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        roleSet.add(Role.ADMIN);
        roleSet.add(Role.STORE_OWNER);
        User user = new User("","","",username,roleSet);
        Store store = new Store(name);

        when(userService.getUserByUsername(username)).thenReturn(Optional.of(user));
        when(storeServiceImp.getStoreByName(name)).thenReturn(Optional.of(store));

        when(storeRepository.save(any())).thenReturn(store);
        when(userRepository.save(any())).thenReturn(user);

        assertEquals(user,storeServiceImp.addcollab(username,name));
    }

    @Test
    public void testgetStoresByUsername() throws Exception{
        // user exist
        String username = "username";
        User user = new User("","","",username);
        when(userService.getUserByUsername(username)).thenReturn(Optional.of(user));
        when(storeRepository.findByStoreOwner_Id(any())).thenReturn(new ArrayList<>());
        RegisterForm registerForm = new RegisterForm("","",username,"");
        assertNotEquals(null,storeServiceImp.getStoresByUsername(registerForm));
    }
    @Test
    public void testgetStoresByUsername1() throws Exception{
        // user doesn't exist
        String username = "username";
        User user = new User("","","",username);
        when(userService.getUserByUsername(username)).thenReturn(Optional.empty());
        when(storeRepository.findByStoreOwner_Id(any())).thenReturn(new ArrayList<>());
        RegisterForm registerForm = new RegisterForm("","",username,"");
        assertEquals(null,storeServiceImp.getStoresByUsername(registerForm));
    }

    @Test
    public void testgetStoresforStoreOwner(){
        String username = "username";
        RegisterForm registerForm = new RegisterForm("","",username,"");
        User user = new User("","","",username);
        when(userService.getUserByUsername(any())).thenReturn(Optional.of(user));
        when(storeRepository.findByStoreOwner_IdAndAndSuggested(any(),anyBoolean())).thenReturn(new ArrayList<>());

        assertNotEquals(null,storeServiceImp.getStoresforStoreOwner(registerForm));
    }

    @Test
    public void testgetStoresforStoreOwner1(){
        String username = "username";
        RegisterForm registerForm = new RegisterForm("","",username,"");
        User user = new User("","","",username);
        when(userService.getUserByUsername(any())).thenReturn(Optional.empty());
        when(storeRepository.findByStoreOwner_IdAndAndSuggested(any(),anyBoolean())).thenReturn(new ArrayList<>());

        assertEquals(null,storeServiceImp.getStoresforStoreOwner(registerForm));
    }


    @Test
    public void testgetStoresforStoreOwner2(){
        String username = "username";
        RegisterForm registerForm = new RegisterForm("","",username,"");
        User user = new User("","","",username);
        when(userService.getUserByUsername(any())).thenReturn(Optional.of(user));
        when(storeRepository.findByStoreOwner_IdAndAndSuggested(any(),anyBoolean())).thenReturn(null);

        assertEquals(null,storeServiceImp.getStoresforStoreOwner(registerForm));
    }

    @Test
    public void testgetStoresforAdmin(){
        String username = "username";
        RegisterForm registerForm = new RegisterForm("","",username,"");
        User user = new User("","","",username);
        when(userService.getUserByUsername(username)).thenReturn(Optional.of(user));
        when(storeRepository.findBySuggested(anyBoolean())).thenReturn(new ArrayList<>());
        assertNotEquals(null,storeServiceImp.getStoresforAdmin(registerForm));
    }

    @Test
    public void testgetStoresforAdmin1(){
        String username = "username";
        RegisterForm registerForm = new RegisterForm("","",username,"");
        User user = new User("","","",username);
        when(userService.getUserByUsername(username)).thenReturn(Optional.empty());
        when(storeRepository.findBySuggested(anyBoolean())).thenReturn(new ArrayList<>());
        assertEquals(null,storeServiceImp.getStoresforAdmin(registerForm));
    }


    @Test
    public void testviewcollab(){
        String storename = "storenaem";
        Store store = new Store(storename);
        store.setCollaborators(new HashSet<>());
        when(storeRepository.findOneByName(storename)).thenReturn(Optional.of(store));
        assertNotEquals(null,storeServiceImp.viewcollab(storename));
    }

    @Test
    public void testviewcollab1(){
        String storename = "storenaem";
        Store store = new Store(storename);
        when(storeRepository.findOneByName(storename)).thenReturn(Optional.empty());
        assertEquals(null,storeServiceImp.viewcollab(storename));
    }

    @Test
    public void testviewactions(){
        String storename = "storename";
        Store store = new Store(storename);
        when(storeRepository.findOneByName(storename)).thenReturn(Optional.of(store));
        assertNotEquals(null,storeServiceImp.viewactions(storename));
    }

    @Test
    public void testviewactions1(){
        String storename = "storename";
        Store store = new Store(storename);
        when(storeRepository.findOneByName(storename)).thenReturn(Optional.empty());
        assertEquals(null,storeServiceImp.viewactions(storename));
    }

}