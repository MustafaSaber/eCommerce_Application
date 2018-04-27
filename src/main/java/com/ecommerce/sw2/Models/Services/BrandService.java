package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Brand;
import com.ecommerce.sw2.forms.AddBrandForm;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */
public interface BrandService {
    Brand AddBrand(AddBrandForm addBrandForm);
}

