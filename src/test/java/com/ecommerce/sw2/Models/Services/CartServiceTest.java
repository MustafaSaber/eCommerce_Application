package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.*;
import com.ecommerce.sw2.Models.Repository.*;
import com.ecommerce.sw2.forms.AddToCartForm;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

@Test
public class CartServiceTest extends AbstractTestNGSpringContextTests{

    @BeforeTest
    void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    CartServiceImp cartServiceImp;

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

    @Mock
    AddProduct addProduct;

    @Mock ProductServiceImpl productService;


    @Mock CartRepository cartRepository;

    @Mock UserRepository userRepository;

    @Mock ProductInCartRepository productInCartRepository;

    @Test
    public void AddToCartTest()
    {
        //All data is right
        /*
        It gave an issue at adding the product to cart as when we use default constructor we don't intialize productd,
        So it was rteurning null,
        SOLVED
         */
        Store store = new Store("store1");
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice((float) 20.5);
        product.setNo_of_items(5);
        product.setName("product1");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = new User("" , "" ,"" , "mostafa" , roleSet);
        Cart cart = new Cart();
        user.setCart(cart);
        AddToCartForm addToCartForm = new AddToCartForm(product.getId(),user.getUsername(), 2);
        when(productService.getProduct(any())).thenReturn(Optional.of(product));
        when(userRepository.findOneByUsername(any())).thenReturn(Optional.of(user));
        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));
        ProductInCart productInCart = new ProductInCart();
        productInCart.equal(product, 2 , cart);
        when(productInCartRepository.findByProduct_IdAndCart_CartID(any() , any())).thenReturn(Optional.of(productInCart));
        when(productInCartRepository.save(any())).thenReturn(productInCart);
        when(cartRepository.save(any())).thenReturn(cart);
        assertEquals(cart , cartServiceImp.AddToCart(addToCartForm));
    }

    @Test
    public void AddToCartTest1()
    {
        //If the product is not found
        Store store = new Store("store1");
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice((float) 20.5);
        product.setNo_of_items(5);
        product.setName("product1");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = new User("" , "" ,"" , "mostafa" , roleSet);
        Cart cart = new Cart();
        user.setCart(cart);
        AddToCartForm addToCartForm = new AddToCartForm(product.getId(),user.getUsername(), 2);
        when(productService.getProduct(any())).thenReturn(Optional.empty());
        when(userRepository.findOneByUsername(any())).thenReturn(Optional.of(user));
        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));
        ProductInCart productInCart = new ProductInCart();
        productInCart.equal(product, 2 , cart);
        when(productInCartRepository.findByProduct_IdAndCart_CartID(any() , any())).thenReturn(Optional.of(productInCart));
        when(productInCartRepository.save(any())).thenReturn(productInCart);
        when(cartRepository.save(any())).thenReturn(cart);
        assertEquals(null , cartServiceImp.AddToCart(addToCartForm));
    }

    @Test
    public void AddToCartTest2()
    {
        //if user is not found
        Store store = new Store("store1");
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice((float) 20.5);
        product.setNo_of_items(5);
        product.setName("product1");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = new User("" , "" ,"" , "mostafa" , roleSet);
        Cart cart = new Cart();
        user.setCart(cart);
        AddToCartForm addToCartForm = new AddToCartForm(product.getId(),user.getUsername(), 2);
        when(productService.getProduct(any())).thenReturn(Optional.of(product));
        when(userRepository.findOneByUsername(any())).thenReturn(Optional.empty());
        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));
        ProductInCart productInCart = new ProductInCart();
        productInCart.equal(product, 2 , cart);
        when(productInCartRepository.findByProduct_IdAndCart_CartID(any() , any())).thenReturn(Optional.of(productInCart));
        when(productInCartRepository.save(any())).thenReturn(productInCart);
        when(cartRepository.save(any())).thenReturn(cart);
        assertEquals(null , cartServiceImp.AddToCart(addToCartForm));
    }

    @Test
    public void AddToCartTest3()
    {
        //if cart is not found (wrong id)
        Store store = new Store("store1");
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice((float) 20.5);
        product.setNo_of_items(5);
        product.setName("product1");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = new User("" , "" ,"" , "mostafa" , roleSet);
        Cart cart = new Cart();
        user.setCart(cart);
        AddToCartForm addToCartForm = new AddToCartForm(product.getId(),user.getUsername(), 2);
        when(productService.getProduct(any())).thenReturn(Optional.of(product));
        when(userRepository.findOneByUsername(any())).thenReturn(Optional.of(user));
        when(cartRepository.findById(any())).thenReturn(Optional.empty());
        ProductInCart productInCart = new ProductInCart();
        productInCart.equal(product, 2 , cart);
        when(productInCartRepository.findByProduct_IdAndCart_CartID(any() , any())).thenReturn(Optional.of(productInCart));
        when(productInCartRepository.save(any())).thenReturn(productInCart);
        when(cartRepository.save(any())).thenReturn(cart);
        assertEquals(null , cartServiceImp.AddToCart(addToCartForm));
    }

    @Test
    public void AddToCartTest4()
    {
        //if product in cart is null shall return right
        Store store = new Store("store1");
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice((float) 20.5);
        product.setNo_of_items(5);
        product.setName("product1");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = new User("" , "" ,"" , "mostafa" , roleSet);
        Cart cart = new Cart();
        user.setCart(cart);
        AddToCartForm addToCartForm = new AddToCartForm(product.getId(),user.getUsername(), 2);
        when(productService.getProduct(any())).thenReturn(Optional.of(product));
        when(userRepository.findOneByUsername(any())).thenReturn(Optional.of(user));
        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));
        ProductInCart productInCart = new ProductInCart();
        productInCart.equal(product, 2 , cart);
        when(productInCartRepository.findByProduct_IdAndCart_CartID(any() , any())).thenReturn(Optional.empty());
        when(productInCartRepository.save(any())).thenReturn(productInCart);
        when(cartRepository.save(any())).thenReturn(cart);
        assertEquals(cart , cartServiceImp.AddToCart(addToCartForm));
    }

    @Test
    public void AddToCartTest5()
    {
        //large quantity
        Store store = new Store("store1");
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice((float) 20.5);
        product.setNo_of_items(5);
        product.setName("product1");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = new User("" , "" ,"" , "mostafa" , roleSet);
        Cart cart = new Cart();
        user.setCart(cart);
        AddToCartForm addToCartForm = new AddToCartForm(product.getId(),user.getUsername(), 20);
        when(productService.getProduct(any())).thenReturn(Optional.of(product));
        when(userRepository.findOneByUsername(any())).thenReturn(Optional.of(user));
        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));
        ProductInCart productInCart = new ProductInCart();
        productInCart.equal(product, 2 , cart);
        when(productInCartRepository.findByProduct_IdAndCart_CartID(any() , any())).thenReturn(Optional.of(productInCart));
        when(productInCartRepository.save(any())).thenReturn(productInCart);
        when(cartRepository.save(any())).thenReturn(cart);
        assertEquals(null , cartServiceImp.AddToCart(addToCartForm));
    }

    @Test
    public void checkout()
    {
        //All thing is right
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice((float) 20.5);
        product.setNo_of_items(5);
        product.setName("product1");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = new User("" , "" ,"" , "mostafa" , roleSet);
        Cart cart = new Cart();
        user.setCart(cart);
        ProductInCart productInCart = new ProductInCart();
        productInCart.equal(product, 2 , cart);
        cart.addProduct(productInCart);
        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));
        when(productService.getProduct(any())).thenReturn(Optional.of(product));
        product.setNo_of_items(product.getNo_of_items()-productInCart.getNo_of_items());
        product.setSold(product.getSold()+product.getNo_of_items());
        when(productRepository.save(any())).thenReturn(product);
        when(cartRepository.save(any())).thenReturn(cart);
        cart.setProducts(new HashSet<>());
        assertEquals(cart.getProducts().size(), cartServiceImp.CheckOut(cart.getCartID()).getProducts().size());
        //assertEquals(cart, cartServiceImp.CheckOut(cart.getCartID()));
    }

    @Test
    public void checkout1()
    {
        //Cart not found
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice((float) 20.5);
        product.setNo_of_items(5);
        product.setName("product1");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = new User("" , "" ,"" , "mostafa" , roleSet);
        Cart cart = new Cart();
        user.setCart(cart);
        ProductInCart productInCart = new ProductInCart();
        productInCart.equal(product, 2 , cart);
        cart.addProduct(productInCart);
        when(cartRepository.findById(any())).thenReturn(Optional.empty());
        when(productService.getProduct(any())).thenReturn(Optional.of(product));
        product.setNo_of_items(product.getNo_of_items()-productInCart.getNo_of_items());
        product.setSold(product.getSold()+product.getNo_of_items());
        when(productRepository.save(any())).thenReturn(product);
        when(cartRepository.save(any())).thenReturn(cart);
        cart.setProducts(new HashSet<>());
        assertEquals(null, cartServiceImp.CheckOut(cart.getCartID()));
        //assertEquals(cart, cartServiceImp.CheckOut(cart.getCartID()));
    }

    @Test
    public void checkout2()
    {
        //product is not found
        Brand brand = new Brand("apple");
        SystemModel systemModel = new SystemModel("iphone" , brand);
        Product product = new Product();
        product.setSystemModel(systemModel);
        product.setPrice((float) 20.5);
        product.setNo_of_items(5);
        product.setName("product1");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.USER);
        User user = new User("" , "" ,"" , "mostafa" , roleSet);
        Cart cart = new Cart();
        user.setCart(cart);
        ProductInCart productInCart = new ProductInCart();
        productInCart.equal(product, 2 , cart);
        cart.addProduct(productInCart);
        when(cartRepository.findById(any())).thenReturn(Optional.of(cart));
        when(productService.getProduct(any())).thenReturn(Optional.empty());
        product.setNo_of_items(product.getNo_of_items()-productInCart.getNo_of_items());
        product.setSold(product.getSold()+product.getNo_of_items());
        when(productRepository.save(any())).thenReturn(product);
        when(cartRepository.save(any())).thenReturn(cart);
        //Same cart with same size.
        assertEquals(cart.getProducts().size(), cartServiceImp.CheckOut(cart.getCartID()).getProducts().size());
        //assertEquals(cart, cartServiceImp.CheckOut(cart.getCartID()));
    }

}
