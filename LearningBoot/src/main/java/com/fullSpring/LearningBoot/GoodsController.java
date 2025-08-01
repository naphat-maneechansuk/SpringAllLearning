package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.dto.GoodsDto;
import com.fullSpring.LearningBoot.dto.InsertGoodsDto;
import com.fullSpring.LearningBoot.entity.Goods;
import com.fullSpring.LearningBoot.entity.Shop;
import com.fullSpring.LearningBoot.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("/{id}")
    public GoodsDto getGoods(@PathVariable("id") String id) {
        Goods goods = goodsRepository.findById(id).orElseThrow();
        return new GoodsDto()
                .setGoodsId(goods.getGoodsId())
                .setGoodsName(goods.getGoodsName())
                .setGoodsPrice(goods.getGoodsPrice())
                .setShopId(goods.getShop().getShopId())
                .setShopName(goods.getShop().getShopName());
    }

    @PostMapping("/insertGoods")
    public GoodsDto insertGoods(@RequestBody InsertGoodsDto insertGoodsDto) {
        Goods goods = new Goods()
                .setGoodsId(insertGoodsDto.getGoodsId())
                .setGoodsName(insertGoodsDto.getGoodsName())
                .setGoodsPrice(insertGoodsDto.getGoodsPrice())
                .setShop(new Shop().setShopId(insertGoodsDto.getShopId()));
        goods = goodsRepository.save(goods);
        return new GoodsDto()
                .setGoodsId(goods.getGoodsId())
                .setGoodsName(goods.getGoodsName())
                .setGoodsPrice(goods.getGoodsPrice())
                .setShopId(goods.getShop().getShopId())
                .setShopName(goods.getShop().getShopName());
    }
}
