package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.dto.GoodsDto;
import com.fullSpring.LearningBoot.entity.Goods;
import com.fullSpring.LearningBoot.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("/getGoods/{id}")
    public GoodsDto getGoods(@PathVariable("id") String id) {
       Goods goods = goodsRepository.findById(id).orElseThrow();
       return new GoodsDto()
               .setGoodsId(goods.getGoodsId())
               .setGoodsName(goods.getGoodsName())
               .setGoodsPrice(goods.getGoodsPrice())
               .setShopId(goods.getShop().getShopId())
               .setShopName(goods.getShop().getShopName());
    }
}
