package com.ecommerce.sw2.Models.Domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_backup")
public class ProductBackup extends Product{


    private Long my_id;

    public Long getMy_id() {
        return my_id;
    }

    public void setMy_id(Long my_id) {
        this.my_id = my_id;
    }

    public void equal (Product product)
    {
        this.setMystore(product.getMystore());
        this.setNo_of_items(product.getNo_of_items());
        this.setName(product.getName());
        this.my_id = product.getId();
        this.setSold(product.getSold());
        this.setPrice(product.getPrice());
        this.setView(product.getView());
        this.setSystemModel(product.getSystemModel());
    }

    public void to (Product product){
        product.setId(this.my_id);
        product.setName(this.getName());
        product.setPrice(this.getPrice());
        product.setView((this.getView()));
        product.setSold(this.getSold());
        product.setNo_of_items(this.getNo_of_items());
        product.setMystore(this.getMystore());
        product.setSystemModel(this.getSystemModel());
    }


}
