package com.ecommerce.sw2.Validators;

import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.forms.AddProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AddProductFormValidators implements Validator {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(AddProductForm.class);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        AddProductForm addProductForm = (AddProductForm) o;
        validatename(errors , addProductForm);
    }

    public void validatename(Errors errors , AddProductForm addProductForm)
    {
        if(addProductForm.getName() == null || addProductForm.getName() == "")
            errors.rejectValue("name" , "NotEmpty");
        // if(productRepository.findOneByName(addProductForm.getName()).isPresent())
           //  errors.rejectValue("name" , "msg.DuplicateProductName");
    }

}
