package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Domain.Action;
import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Repository.ActionRepository;
import com.ecommerce.sw2.Models.Repository.ProductBackUpRepository;
import com.ecommerce.sw2.Models.Repository.ProductRepository;
import com.ecommerce.sw2.Models.Services.ActionService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Mina_Yousry on 15/04/2018.
 */
@Controller
public class ActionController {
    @Autowired
    ActionRepository actionRepository;

    @Autowired
    ProductBackUpRepository productBackUpRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ActionService actionService;



    @RequestMapping(value = "/undo",method = RequestMethod.POST)
    public ResponseEntity<?> undo(@RequestBody Long id){
       // System.out.println("id = herrrrrree >> "+id);
        List<Action> actions = actionRepository.findAll();
        Action action = actionRepository.getOne(id);
        if (action == null)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","null");
            return ResponseEntity.ok().body(jsonObject);
        }
        Product product = actionService.undo(id);
        if (product == null)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","null");
            jsonObject.put("cause","This product is deleted");
            return ResponseEntity.ok().body(jsonObject);
        }
        return ResponseEntity.ok().body(product);
    }


}
