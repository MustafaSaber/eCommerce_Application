package com.ecommerce.sw2.Models.Domain;

import com.ecommerce.sw2.Models.Repository.ActionRepository;
import com.ecommerce.sw2.Models.Repository.ProductBackUpRepository;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Repository.StoreRepository;

import javax.persistence.*;

@Entity
@Table(name = "action")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "actionType",discriminatorType=DiscriminatorType.STRING)
public abstract class Action {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "id" , nullable = false , updatable = false)
    protected Long id;

    @ManyToOne
    protected ProductBackup productBackup;
    Action(){
        productBackup = new ProductBackup();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductBackup getProductBackup() {
        return productBackup;
    }

    public void setProductBackup(ProductBackup productBackup) {
        this.productBackup = productBackup;
    }

    public abstract Product Do(Product product, ActionRepository actionRepository, ProductRepository productRepository, ProductBackUpRepository productBackUpRepository , StoreRepository storeRepository);

    public abstract Product Undo(Long id,ActionRepository actionRepository,ProductRepository productRepository, ProductBackUpRepository productBackUpRepository , StoreRepository storeRepository);

}
