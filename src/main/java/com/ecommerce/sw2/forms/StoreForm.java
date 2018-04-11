package com.ecommerce.sw2.forms;

import javax.validation.constraints.NotEmpty;

public class StoreForm {

    @NotEmpty
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
