package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.entity.Shop;
import com.fullSpring.LearningBoot.repository.ShopRepositoy;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestJpaController {
    @Autowired
    private ShopRepositoy shopRepositoy;

    @GetMapping("jpa/getById")
    public Shop getByIdJpa(@RequestParam("id") String id ){
        return shopRepositoy.findById(id).orElse(null);
    }


    @PostMapping("jpa/insertShop")
    public Shop insertJpa(@RequestBody Shop shop) {
        return shopRepositoy.save(shop);
    }

    @PostMapping("jpa/updateShop")
    public Shop updateJpa(@RequestBody Shop shop) {
        return shopRepositoy.save(shop);
    }
}
