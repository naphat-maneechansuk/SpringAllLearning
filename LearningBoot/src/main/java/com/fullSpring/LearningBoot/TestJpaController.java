package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.dto.ShopDto;
import com.fullSpring.LearningBoot.entity.Shop;
import com.fullSpring.LearningBoot.repository.ShopRepositoy;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestJpaController {
    @Autowired
    private ShopRepositoy shopRepositoy;

    @GetMapping("jpa/getById")
    public Shop getByIdJpa(@RequestParam("id") String id ){
        return shopRepositoy.findById(id).orElse(null);
    }

    @Transactional
    @PostMapping("jpa/insertShop")
    public Shop insertJpa(@RequestBody Shop shop) {
        return shopRepositoy.save(shop);
    }
}
