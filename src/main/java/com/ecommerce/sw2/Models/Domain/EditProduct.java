package com.ecommerce.sw2.Models.Domain;

import com.ecommerce.sw2.Models.Repository.ActionRepository;
import com.ecommerce.sw2.Models.Repository.ProductBackUpRepository;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Created by Mina_Yousry on 15/04/2018.
 */
@Entity(name = "EditProduct")
@Indexed
@DiscriminatorValue(value = "edit_product")
public class EditProduct extends Action {


    public EditProduct(){
        super();
    }

    @Override
    public Product Do(Product product,ActionRepository actionRepository,ProductRepository productRepository, ProductBackUpRepository productBackUpRepository) {
        Product oldp = productRepository.findById(product.getId()).get();
        this.productBackup.equal(oldp);
        product = productRepository.save(product);
        this.productBackup = productBackUpRepository.save(productBackup);
        actionRepository.save(this);
        return productRepository.save(product);
    }

    @Override
    public Product Undo(Long id,ActionRepository actionRepository,ProductRepository productRepository, ProductBackUpRepository productBackUpRepository) {
        Action editProduct = actionRepository.getOne(id);
        Product p = new Product();
        editProduct.productBackup.to(p);
        return Do(p,actionRepository,productRepository,  productBackUpRepository);
    }
}