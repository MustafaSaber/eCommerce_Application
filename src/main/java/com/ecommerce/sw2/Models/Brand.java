package com.ecommerce.sw2.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Vector;
@Entity
public class Brand {
    @Id
    String name;
    //Vector<Model> models = new Vector<Model>();

    public Brand(String name) {
        this.name = name;
    }

//    public Brand(String name, Vector<Model> models) {
//        this.name = name;
//        //this.models = models;
//    }

    public Brand() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public Vector<Model> getModels() {
      //  return models;
    //}

    //public void setModels(Vector<Model> models) {
      //  this.models = models;
    //}
}