package com.ecommerce.sw2.forms;

import javax.validation.constraints.*;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */
public class AddBrandForm {
    @NotEmpty
    @Size(min = 2, max = 40)
    private String name;

    public AddBrandForm(){
    }

    public AddBrandForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
