package com.ecommerce.sw2.forms;

import javax.validation.constraints.NotEmpty;

public class StoreForm {

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String store_owner_name = "";

    public String getStore_owner_name() {
        return store_owner_name;
    }

    public void setStore_owner_name(String store_owner_name) {
        this.store_owner_name = store_owner_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
