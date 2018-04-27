package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Product;
import org.springframework.stereotype.Service;

/**
 * Created by Mina_Yousry on 15/04/2018.
 */
public interface ActionService {
    public Product undo(Long id);
}
