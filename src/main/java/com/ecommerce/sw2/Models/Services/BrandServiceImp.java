package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Brand;
import com.ecommerce.sw2.Models.Repository.BrandRepository;
import com.ecommerce.sw2.forms.AddBrandForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */

@Service
public class BrandServiceImp implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public Brand AddBrand(AddBrandForm addBrandForm) {
        Brand brand = new Brand(addBrandForm.getName());
        return brandRepository.save(brand);
    }
}
