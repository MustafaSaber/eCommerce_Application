package com.ecommerce.sw2.forms;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class AddProductForm {

    @NotEmpty
    private String name;

    @NotEmpty
    private String model_name;

    @NotEmpty
    private  String storename;

    @Min(value = 1)
    private float price;

    @Min(value = 1)
    private int number_of_items;


    public int getNumber_of_items() {
        return number_of_items;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public void setNumber_of_items(int number_of_items) {
        this.number_of_items = number_of_items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
