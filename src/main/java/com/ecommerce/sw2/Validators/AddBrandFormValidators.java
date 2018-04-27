package com.ecommerce.sw2.Validators;

import com.ecommerce.sw2.Models.Repository.BrandRepository;
import com.ecommerce.sw2.forms.AddBrandForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */

@Component
public class AddBrandFormValidators implements Validator {
    @Autowired
    BrandRepository brandRepository;
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(AddBrandForm.class);
    }

    @Override
    public void validate(@Nullable Object target, Errors errors) {
        AddBrandForm form = (AddBrandForm) target;
        validatename(errors,form);
    }

    private void validatename(Errors errors,AddBrandForm addBrandForm)
    {
        if (errors.hasFieldErrors("name"))
            return;
        if(brandRepository.findByName(addBrandForm.getName()).isPresent()) {
            errors.rejectValue("name","msg.DuplicateBrandName");
        }
    }
}
