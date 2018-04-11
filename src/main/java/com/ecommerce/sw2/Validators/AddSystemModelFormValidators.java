package com.ecommerce.sw2.Validators;

import com.ecommerce.sw2.Models.Repository.BrandRepository;
import com.ecommerce.sw2.Models.Repository.SystemModelRepository;
import com.ecommerce.sw2.forms.AddBrandForm;
import com.ecommerce.sw2.forms.AddSystemModelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */
@Component
public class AddSystemModelFormValidators implements Validator {
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    SystemModelRepository systemModelRepository;
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(AddSystemModelForm.class);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        AddSystemModelForm form = (AddSystemModelForm) o;
        validate(errors,form);
    }
    private void validate(Errors errors, AddSystemModelForm form)
    {
        if (errors.hasFieldErrors())
            return;
        if(systemModelRepository.findByName(form.getModelname()).isPresent()) {
            errors.rejectValue("modelname","msg.DuplicateModelName");
        }
        if(!brandRepository.findByName(form.getBrandname()).isPresent()) {
            errors.rejectValue("brandname","brand name doesn't existed");
        }
    }
}










