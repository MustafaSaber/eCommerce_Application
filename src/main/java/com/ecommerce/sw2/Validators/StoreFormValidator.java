package com.ecommerce.sw2.Validators;

import com.ecommerce.sw2.Models.Repository.StoreRepository;
import com.ecommerce.sw2.forms.StoreForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StoreFormValidator implements Validator {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public boolean supports(Class<?> aClass) { return aClass.equals(StoreForm.class); }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        StoreForm storeForm = (StoreForm) o;
        validatename(errors, storeForm);
    }

    public void validatename(Errors errors , StoreForm storeForm)
    {
        if(storeForm.getName() == null || storeForm.getName() == "")
            errors.rejectValue("name" , "NotEmpty");
        if(storeRepository.findOneByName(storeForm.getName()).isPresent())
            errors.rejectValue("name" , "msg.DuplicateStoreName");
    }
}
