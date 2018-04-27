package com.ecommerce.sw2.Controllers;

import com.ecommerce.sw2.Models.Domain.Product;
import com.ecommerce.sw2.Models.Domain.QProduct;
import com.ecommerce.sw2.Models.Domain.QUser;
import com.ecommerce.sw2.Models.Domain.User;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Mina_Yousry on 25/04/2018.
 */
@RestController
public class Test {

    @Autowired
    private EntityManager entityManager;

    @RequestMapping(value = "/try",method = RequestMethod.GET)
    public ResponseEntity<?> getuser(){
        JPAQuery<Product> query = new JPAQuery<>(entityManager);

        QProduct qProduct = QProduct.product;
        QProduct qProduct1 = new QProduct("qProduct1");

        Predicate username1 = qProduct.name.eq("1");
        //List<Product> products = query.from(qProduct).select(Product).where(username1).fetch();
        //query.from(qProduct).where(qProduct.view.eq(JPAExpressions.select(qProduct1.sold.max()).from(qProduct1))).fetch();
        //return ResponseEntity.ok(query.from(qProduct).where(qProduct.price.eq(JPAExpressions.select(qProduct1.price.min()).from(qProduct1))).fetch().get(0));
        return ResponseEntity.ok(query.select(qProduct.price.max()).from(qProduct)
                .fetch().get(0));
    }
}
