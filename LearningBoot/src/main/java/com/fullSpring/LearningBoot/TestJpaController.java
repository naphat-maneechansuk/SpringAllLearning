package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.entity.Shop;
import com.fullSpring.LearningBoot.repository.ShopRepositoy;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class TestJpaController{
    @Autowired
    private ShopRepositoy shopRepositoy;

    @GetMapping("/getById")
    public Shop getByIdJpa(@RequestParam("id") String id ){
        return shopRepositoy.findById(id).orElse(null);
    }


    @PostMapping("/insertShop")
    public Shop insertJpa(@RequestBody Shop shop) {
        return shopRepositoy.save(shop);
    }

    @PostMapping("/updateShop")
    public Shop updateJpa(@RequestBody Shop shop) {
        return shopRepositoy.save(shop);
    }

    @GetMapping("/deleteShopById")
    public boolean deleteShop(@RequestParam("id") String id) {
        if (!shopRepositoy.existsById(id)) {
            System.out.println("Shop with ID " + id + " does not exist.");
            return false;
        }
        shopRepositoy.deleteById(id);
        return !shopRepositoy.existsById(id);
    }

    @GetMapping("/getAllShops")
    public List<Shop> getAllShops() {
        return shopRepositoy.findAll();
    }

    @GetMapping("/getByShopName")
    public List<Shop> getByShopName(@RequestParam("shopName") String shopName) {
        return shopRepositoy.findByShopName(shopName);
    }

    @GetMapping("/getByShopNameNotLike")
    public List<Shop> getByShopNameNotLike(@RequestParam("shopName") String shopName) {
        return shopRepositoy.findByShopNameNotLike(shopName);
    }


    @GetMapping("/getByJpqlShopName")
    public List<Shop> getByJpqlShopName(@RequestParam("inputString") String inputString) {
        return shopRepositoy.findByJpqlShopName(inputString);
    }
}
