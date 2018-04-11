package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Brand;
import com.ecommerce.sw2.Models.Domain.SystemModel;
import com.ecommerce.sw2.Models.Repository.BrandRepository;
import com.ecommerce.sw2.Models.Repository.SystemModelRepository;
import com.ecommerce.sw2.forms.AddSystemModelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.SampleModel;
import java.util.Optional;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */

@Service
public class SystemModelServiceImp implements SystemModelService {
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    SystemModelRepository systemModelRepository;

    @Override
    public SystemModel AddSystemModel(AddSystemModelForm addSystemModelForm) {
        Brand brand = brandRepository.getBrandByName(addSystemModelForm.getBrandname());
        if (brand == null)
            return null;
        SystemModel systemModel = new SystemModel(addSystemModelForm.getModelname(),brand);
        return systemModelRepository.save(systemModel);
    }
}
