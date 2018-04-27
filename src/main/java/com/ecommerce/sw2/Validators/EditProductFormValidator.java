package com.ecommerce.sw2.Validators;

import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.forms.AddToCartForm;
import com.ecommerce.sw2.forms.EditProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * Created by Mina_Yousry on 16/04/2018.
 */
@Component
public class EditProductFormValidator implements Validator {
    @Autowired
    ProductRepository productRepository;


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(EditProductForm.class);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        EditProductForm form = (EditProductForm) o;
        validate(errors,form);
    }
    private void validate(Errors errors, EditProductForm form)
    {
        if (errors.hasFieldErrors())
            return;
        Optional<Product> product = productRepository.findById(form.getId());
        if (!product.isPresent())
        {
            errors.rejectValue("id","msg.ProductNotExist");
        }
    }
}
