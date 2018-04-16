package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.*;
import com.ecommerce.sw2.Models.Repository.*;
import com.ecommerce.sw2.forms.AddProductForm;
import com.ecommerce.sw2.forms.EditProductForm;
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
    private ProductBackUpRepository productBackUpRepository;

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private StoreService storeService;

    @Autowired
    private SystemModelRepository systemModelRepository;

    @Autowired
    private ActionRepository actionRepository;

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

        AddProduct addProduct = new AddProduct();
        return addProduct.Do(product,actionRepository,productRepository,productBackUpRepository);
//        return productRepository.save(product);
    }


    public Collection<Product> getProductsByStore(StoreForm form)
    {
        Optional<Store> store = storeService.getStoreByName(form.getName());
        if(store.isPresent())
            return productRepository.findByMystore_Id(store.get().getId());

        Collection<Product> col = null;
        return col;
    }

    @Override
    public Product edit(EditProductForm editProductForm) {
        Product product = productRepository.findById(editProductForm.getId()).get();//productRepository.getOne(editProductForm.getId());
        product.setName(editProductForm.getName());
        product.setPrice(editProductForm.getPrice());
        product.setNo_of_items(editProductForm.getNumberofitems());
        EditProduct editProduct = new EditProduct();
        return editProduct.Do(product,actionRepository,productRepository,productBackUpRepository);
    }
}