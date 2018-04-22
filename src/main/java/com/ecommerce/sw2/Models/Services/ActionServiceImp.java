package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Action;
import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Repository.ActionRepository;
import com.ecommerce.sw2.Models.Repository.ProductBackUpRepository;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mina_Yousry on 15/04/2018.
 */
@Service
public class ActionServiceImp implements ActionService {
    @Autowired
    ActionRepository actionRepository;

    @Autowired
    ProductBackUpRepository productBackUpRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Product undo(Long id) {
        Action action =actionRepository.getOne(id);
        Product p = action.Undo(id,actionRepository,productRepository,productBackUpRepository , storeRepository);
        actionRepository.delete(action);
        productBackUpRepository.delete(action.getProductBackup());
        return p;
    }
}
