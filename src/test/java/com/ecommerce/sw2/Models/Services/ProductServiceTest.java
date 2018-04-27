package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.*;
import com.ecommerce.sw2.Models.Repository.*;
import com.ecommerce.sw2.forms.AddProductForm;
import com.ecommerce.sw2.forms.StoreForm;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

@Test
public class ProductServiceTest extends AbstractTestNGSpringContextTests {

    @BeforeTest
    void setup() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    BrandRepository brandRepository;

    @Mock
    StoreRepository storeRepository;

    @Mock
    SystemModelRepository systemModelRepository;

    @Mock
    ProductRepository productRepository;

    @Mock
    ActionRepository actionRepository;

    @Mock ProductBackUpRepository backUpRepository;

    @Mock StoreService storeService;

    @Mock AddProduct addProduct;


    /*@Test
    public void TestAddProduct()
    {
        // store not found
        AddProductForm addProductForm = new AddProductForm();
        addProductForm.setName("product1");
        addProductForm.setModel_name("iphone");
        addProductForm.setNumber_of_items(10);
        addProductForm.setPrice((float) 20.5);
        addProductForm.setStorename("store1");
        Store store = new Store("store1");
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice(addProductForm.getPrice());
        product.setNo_of_items(product.getNo_of_items());
        product.setName(addProductForm.getName());
        when(storeRepository.findOneByName(any())).thenReturn(Optional.empty());
        when(systemModelRepository.findByName(any())).thenReturn(Optional.of(systemModel));
        when(systemModelRepository.save(any())).thenReturn(systemModel);
        when(productRepository.save(any())).thenReturn(product);

        assertEquals(null , productService.addProduct(addProductForm));
    }*/

    /*@Test
    public void TestAddProduct1()
    {
        // store is found and all data is right
        AddProductForm addProductForm = new AddProductForm();
        addProductForm.setName("product1");
        addProductForm.setModel_name("iphone");
        addProductForm.setNumber_of_items(10);
        addProductForm.setPrice((float) 20.5);
        addProductForm.setStorename("store1");
        Store store = new Store("store1");
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice(addProductForm.getPrice());
        product.setNo_of_items(product.getNo_of_items());
        product.setName(addProductForm.getName());
        when(storeRepository.findOneByName(any())).thenReturn(Optional.of(store));
        when(systemModelRepository.findByName(any())).thenReturn(Optional.of(systemModel));
        when(systemModelRepository.save(any())).thenReturn(systemModel);
        product.setMystore(store);
        //assertEquals(product , productService.addProduct(addProductForm));
        when(addProduct.Do(any(), any() , any() , any(), any())).thenReturn(product);
        assertEquals(product , productService.addProduct(addProductForm));
        //when(productRepository.save(any())).thenReturn(product);
        //ProductBackup productBackup = new ProductBackup();

    }

    @Test
    public void TestAddProduct2()
    {
        // systemmodel is not found and all data is right
        AddProductForm addProductForm = new AddProductForm();
        addProductForm.setName("product1");
        addProductForm.setModel_name("iphone");
        addProductForm.setNumber_of_items(10);
        addProductForm.setPrice((float) 20.5);
        addProductForm.setStorename("store1");
        Store store = new Store("store1");
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice(addProductForm.getPrice());
        product.setNo_of_items(product.getNo_of_items());
        product.setName(addProductForm.getName());
        when(storeRepository.findOneByName(any())).thenReturn(Optional.of(store));
        when(systemModelRepository.findByName(any())).thenReturn(Optional.empty());
        when(systemModelRepository.save(any())).thenReturn(systemModel);
        when(productRepository.save(any())).thenReturn(product);

        assertEquals(null , productService.addProduct(addProductForm));
    }*/

   @Test
   public void GetProductsBystoreTest()
   {
       //Everything is right
       Store store = new Store("store1");
       Collection<Product> products = new ArrayList<>();
       Product product = new Product(); product.setMystore(store);  products.add(product);
       Product product1 = new Product(); product1.setMystore(store); products.add(product1);
       Product product2 = new Product(); product2.setMystore(store); products.add(product2);
       store.addproduct(product);
       store.addproduct(product1);
       store.addproduct(product2);
       when(storeService.getStoreByName(any())).thenReturn(Optional.of(store));
       when(productRepository.findByMystore_Id(any())).thenReturn(products);
       StoreForm storeForm = new StoreForm();
       storeForm.setName("store1");
       assertEquals(3 , productService.getProductsByStore(storeForm).size());
   }

    @Test
    public void GetProductsBystoreTest1()
    {
        //Store not found
        Store store = new Store("store1");
        Collection<Product> products = new ArrayList<>();
        Product product = new Product(); product.setMystore(store);  products.add(product);
        Product product1 = new Product(); product1.setMystore(store); products.add(product1);
        Product product2 = new Product(); product2.setMystore(store); products.add(product2);
        store.addproduct(product);
        store.addproduct(product1);
        store.addproduct(product2);
        when(storeService.getStoreByName(any())).thenReturn(Optional.empty());
        when(productRepository.findByMystore_Id(any())).thenReturn(products);
        StoreForm storeForm = new StoreForm();
        storeForm.setName("store1");
        assertEquals(null , productService.getProductsByStore(storeForm));
    }

    @Test
    public void viewproductTest()
    {
        //Product not found
        Product product = new Product();
        int oldval = product.getView();
        when(productService.getProduct(any())).thenReturn(Optional.of(product));
        when(productRepository.save(any())).thenReturn(product);

        assertEquals(oldval+1 , productService.viewproduct(product.getId()).getView());
    }

}
