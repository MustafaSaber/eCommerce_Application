package com.ecommerce.sw2.Models.Domain;

import org.springframework.stereotype.Indexed;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Indexed
@DiscriminatorValue(value = "add_product")
public class addProduct extends Action {


    @Override
    public boolean Do(Long id) {
        return false;
    }

    @Override
    public boolean Undo(Long id) {
        return false;
    }
}
