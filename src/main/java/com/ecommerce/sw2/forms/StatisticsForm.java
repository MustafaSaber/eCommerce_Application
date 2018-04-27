package com.ecommerce.sw2.forms;

import javax.validation.constraints.NotEmpty;

public class StatisticsForm
{
    private Long id;

    @NotEmpty
    private String entity = "";

    @NotEmpty
    private String attribute = "";

    @NotEmpty
    private String function = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
