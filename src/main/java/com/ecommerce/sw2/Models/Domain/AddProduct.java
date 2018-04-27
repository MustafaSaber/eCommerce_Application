package com.ecommerce.sw2.Models.Domain;

import com.ecommerce.sw2.Models.Repository.ActionRepository;
import com.ecommerce.sw2.Models.Repository.ProductBackUpRepository;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;


@Entity(name = "AddProduct")
@DiscriminatorValue(value = "add_product")
public class AddProduct extends Action {
//    @Autowired
//    @Transient
//    ActionRepository actionRepository;
//
//    @Autowired
//    @Transient
//    ProductRepository productRepository;

    public AddProduct(){
        super();
    }

    @Override
    public Product Do(Product product, ActionRepository actionRepository, ProductRepository productRepository, ProductBackUpRepository productBackUpRepository  , StoreRepository storeRepository) {
        product = productRepository.save(product);
        this.productBackup.equal(product);
        this.productBackup = productBackUpRepository.save(this.getProductBackup());
        actionRepository.save(this);
        product.getMystore().addAction(this);
        storeRepository.save(product.getMystore());
        return product;
//        return new Product();
    }

    @Override
    public Product Undo(Long id, ActionRepository actionRepository, ProductRepository productRepository, ProductBackUpRepository productBackUpRepository , StoreRepository storeRepository) {
        Action action = actionRepository.getOne(id);
        RemoveProduct removeProduct = new RemoveProduct();
        Product p = new Product();
        action.productBackup.to(p);
        return removeProduct.Do(p,actionRepository,productRepository,  productBackUpRepository , storeRepository);
//        return new Product();
    }
}
