package com.ecommerce.sw2.Models.Domain;

import javax.persistence.*;

@Entity
@Table(name = "action")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "actionType")
public abstract class Action {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "id" , nullable = false , updatable = false)
    protected Long id;

    public abstract boolean Do(Long id);

    public abstract boolean Undo(Long id);

}
