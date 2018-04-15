package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.*;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Repository.StoreRepository;
import com.ecommerce.sw2.Models.Repository.SystemModelRepository;
import com.ecommerce.sw2.Models.Repository.UserRepository;
import com.ecommerce.sw2.forms.AddProductForm;
import com.ecommerce.sw2.forms.RegisterForm;
import com.ecommerce.sw2.forms.StoreForm;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private StoreService storeService;

    @Autowired
    private SystemModelRepository systemModelRepository;

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product addProduct(AddProductForm addProductForm) {
        Product product = new Product();
        product.setName(addProductForm.getName());
        product.setPrice(addProductForm.getPrice());
        product.setNo_of_items(addProductForm.getNumber_of_items());
        //Get the store and the model
        Optional<Store> store = storeRepository.findOneByName(addProductForm.getStorename());
        Optional<SystemModel> systemModel = systemModelRepository.findByName(addProductForm.getModel_name());
        //check done in validation
        if(! store.get().getSuggested() ) return null;
        product.setMystore(store.get());
        product.setSystemModel(systemModel.get());
        //add the product to the system model and save it again
        systemModel.get().addproduct(product);
        systemModelRepository.save(systemModel.get());

        ProductBackup productBackup = new ProductBackup();

        return productRepository.save(product);
    }


    public Collection<Product> getProductsByStore(StoreForm form)
    {
        Optional<Store> store = storeService.getStoreByName(form.getName());
        if(store.isPresent())
            return productRepository.findByMystore_Id(store.get().getId());

        Collection<Product> col = null;
        return col;
    }

    public Collection<Product> viewProducts()
    {

        return productRepository.findAll();
    }
}