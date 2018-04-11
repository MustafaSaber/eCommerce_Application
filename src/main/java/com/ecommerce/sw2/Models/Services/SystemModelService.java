package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.SystemModel;
import com.ecommerce.sw2.forms.AddSystemModelForm;

import java.util.Optional;

/**
 * Created by Mina_Yousry on 11/04/2018.
 */
public interface SystemModelService {
    SystemModel AddSystemModel(AddSystemModelForm addSystemModelForm);
}
