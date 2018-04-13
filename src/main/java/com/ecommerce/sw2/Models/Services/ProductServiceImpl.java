package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Domain.Store;
import com.ecommerce.sw2.Models.Domain.User;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Repository.StoreRepository;
import com.ecommerce.sw2.Models.Repository.UserRepository;
import com.ecommerce.sw2.forms.AddProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Product addProduct(AddProductForm addProductForm) {
        Product product = new Product();
        product.setName(addProductForm.getName());
        product.setPrice(addProductForm.getPrice());
        product.setNo_of_items(addProductForm.getNumber_of_items());
        Optional<Store> store = storeRepository.findOneByName(addProductForm.getStorename());
        if(store.isPresent())
        {
            product.setMystore(store.get());
            if(store.get().getSuggested() == false) return null;
        }
        return productRepository.save(product);
    }
}
