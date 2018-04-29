package com.ecommerce.sw2.Models.Services;

import com.ecommerce.sw2.Models.Domain.Action;
import com.ecommerce.sw2.Models.Domain.AddProduct;
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

    @Autowired
    ProductService productService;

    @Override
    public Product undo(Long id) {
        Action action = actionRepository.getOne(id);
        if (action == null)
            return null;
        if (action.getProductBackup().getMy_id() == null)
            return null;
        Long pid = action.getProductBackup().getMy_id();
        Product p = action.Undo(id,actionRepository,productRepository,productBackUpRepository , storeRepository);
        if (action instanceof AddProduct){
            productService.MakeProductBackUpPIDWithNulls(pid);
            productService.MakeProductInCartProductIDWithNulls(pid);
        }
        actionRepository.delete(action);
        productBackUpRepository.delete(action.getProductBackup());
        return p;
    }
}
