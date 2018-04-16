package com.ecommerce.sw2.forms;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
public class AddToCartForm {
    private Long productid;
    private String username;

    @Range(min = 1)
    private int quantity;

    public AddToCartForm() {
    }

    public AddToCartForm(Long productid, String username, int quantity) {
        this.productid = productid;
        this.username = username;
        this.quantity = quantity;
    }
    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String cartid) {
        this.username = cartid;
    }
}
