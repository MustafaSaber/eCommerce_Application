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
    private Long cartid;
    @Range(min = 1)
    private int quantity;

    public AddToCartForm() {
    }

    public AddToCartForm(Long productid, Long cartid, int quantity) {
        this.productid = productid;
        this.cartid = cartid;
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

    public Long getCartid() {
        return cartid;
    }

    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }
}
