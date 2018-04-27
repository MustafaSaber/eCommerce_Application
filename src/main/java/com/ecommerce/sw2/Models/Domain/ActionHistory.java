package com.ecommerce.sw2.Models.Domain;

public class ActionHistory {
    protected Long id;
    protected String action_type;
    protected Long product_backup_id;
    protected String product_name;

    public ActionHistory() {
    }

    public ActionHistory(Long id, String action_type, Long product_backup_id, String product_name) {
        this.id = id;
        this.action_type = action_type;
        this.product_backup_id = product_backup_id;
        this.product_name = product_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public Long getProduct_backup_id() {
        return product_backup_id;
    }

    public void setProduct_backup_id(Long product_backup_id) {
        this.product_backup_id = product_backup_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
