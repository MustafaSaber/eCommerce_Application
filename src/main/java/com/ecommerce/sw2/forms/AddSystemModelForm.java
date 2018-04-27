package com.ecommerce.sw2.forms;

import org.springframework.stereotype.Component;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */
@Component
public class AddSystemModelForm {
    private String modelname;
    private String brandname;


    public AddSystemModelForm(){
    }

    public AddSystemModelForm(String modelname, String brandname) {
        this.modelname = modelname;
        this.brandname = brandname;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
}
