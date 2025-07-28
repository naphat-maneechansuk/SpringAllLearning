package com.fullSpring.LearningBoot;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConnectdbApplication {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/test-db")
    public void testDB(){
       List<Tuple> resultFromDb = entityManager.createNativeQuery("SELECT * FROM shop" , Tuple.class).getResultList();
       for (Tuple tuple : resultFromDb) {
           String shop_id = tuple.get("shop_id",String.class);
           String shop_name = tuple.get("shop_name",String.class);

           System.out.println("Shop ID: " + shop_id + ", Shop Name: " + shop_name);
       }
    }
}
