package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.dto.ShopDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConnectdbApplication {
    @PersistenceContext
    public EntityManager entityManager;

    @GetMapping("/test-db")
    public void testDB(){
       List<Tuple> resultFromDb = entityManager.createNativeQuery("SELECT * FROM shop" , Tuple.class).getResultList();
       for (Tuple tuple : resultFromDb) {
           String shop_id = tuple.get("shop_id",String.class);
           String shop_name = tuple.get("shop_name",String.class);
           System.out.println("Shop ID: " + shop_id + ", Shop Name: " + shop_name);
       }
    }

    @GetMapping("/getById")
    public ShopDto getById(@RequestParam("id") String id ){
        List<Tuple> resultFromDb = entityManager.createNativeQuery("SELECT * FROM shop WHERE shop_id = :inputId ", Tuple.class)
                .setParameter("inputId", id)
                .getResultList();
        if (resultFromDb.isEmpty()) {
            return null;
        }else {
            Tuple tuple = resultFromDb.get(0);
            ShopDto shopDto = new ShopDto();
            shopDto.setShopId(tuple.get("shop_id", String.class));
            shopDto.setShopName(tuple.get("shop_name", String.class));
            return shopDto;
        }
    }

    @Transactional
    @GetMapping("/insertShop")
    public boolean insertShop(@RequestBody ShopDto shopDto) {
        int roleEffect = entityManager.createNativeQuery("INSERT INTO shop (shop_id, shop_name) VALUES (:shopId, :shopName)")
                .setParameter("shopId", shopDto.getShopId())
                .setParameter("shopName", shopDto.getShopName())
                .executeUpdate();
        return roleEffect > 0;
    }
}
