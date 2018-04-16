package com.ecommerce.sw2.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Mina_Yousry on 16/04/2018.
 */
public class EditProductForm {
    private Long id;

    private String name;

    @Min(value = 1)
    private float price;

    @Min(value = 1)
    private int numberofitems;


    public int getNumberofitems() {
        return numberofitems;
    }

    public void setNumberofitems(int number_of_items) {
        this.numberofitems = number_of_items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
