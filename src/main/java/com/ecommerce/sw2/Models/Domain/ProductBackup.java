package com.ecommerce.sw2.Models.Domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_backup")
public class ProductBackup extends Product{


    private Long pid;

    public Long getMy_id() {
        return pid;
    }

    public void setMy_id(Long my_id) {
        this.pid = my_id;
    }


    public void equal (Product product)
    {
        this.setMystore(product.getMystore());
        this.setNo_of_items(product.getNo_of_items());
        this.setName(product.getName());
        this.pid = product.getId();
        this.setSold(product.getSold());
        this.setPrice(product.getPrice());
        this.setView(product.getView());
        this.setSystemModel(product.getSystemModel());
    }

    public void to (Product product){
        product.setId(this.pid);
        product.setName(this.getName());
        product.setPrice(this.getPrice());
        product.setView((this.getView()));
        product.setSold(this.getSold());
        product.setNo_of_items(this.getNo_of_items());
        product.setMystore(this.getMystore());
        product.setSystemModel(this.getSystemModel());
    }


}
