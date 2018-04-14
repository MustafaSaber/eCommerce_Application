package com.ecommerce.sw2.Validators;

import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Repository.BrandRepository;
import com.ecommerce.sw2.Models.Repository.CartRepository;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Repository.SystemModelRepository;
import com.ecommerce.sw2.forms.AddSystemModelForm;
import com.ecommerce.sw2.forms.AddToCartForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Mina_Yousry on 14/04/2018.
 */
@Component
public class AddToCartFormValidator implements Validator{
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(AddToCartForm.class);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        AddToCartForm form = (AddToCartForm) o;
        validate(errors,form);
    }
    private void validate(Errors errors, AddToCartForm form)
    {
        if (errors.hasFieldErrors())
            return;
        Optional<Product> product = productRepository.findById(form.getProductid());
        if (!product.isPresent())
            errors.rejectValue("productid","msg.ProductNotExist");
        if (!cartRepository.findById(form.getCartid()).isPresent())
            errors.rejectValue("cartid","msg.CartNotExist");
        if (product.isPresent() && product.get().getNo_of_items() < form.getQuantity())
            errors.rejectValue("quantity", "msg.NotEnoughQuantity");
    }

}
