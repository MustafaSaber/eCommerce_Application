package com.ecommerce.sw2.Controllers;

//import com.ecommerce.sw2.Models.Domain.QUser;
import com.ecommerce.sw2.Models.Domain.User;
import com.querydsl.core.types.Predicate;
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
/*
    @Autowired
    private EntityManager entityManager;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ResponseEntity<?> getuser(){
        JPAQuery<User> query = new JPAQuery<>(entityManager);

        QUser qUser = QUser.user;

        Predicate username1 = qUser.user.username.eq("1");
        List<User> users = query.from(qUser).where(username1).fetch();
        return ResponseEntity.ok(users);
    }
*/
}
