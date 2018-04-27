package com.ecommerce.sw2.forms;

import javax.validation.constraints.NotEmpty;

public class StatisticsForm
{
    private Long id;

    @NotEmpty
    private String table = "";

    @NotEmpty
    private String column = "";

    @NotEmpty
    private String function = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
