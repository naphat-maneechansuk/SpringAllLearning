package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.dto.GetOrderGoodsDto;
import com.fullSpring.LearningBoot.dto.InsertOrderGoodsDto;
import com.fullSpring.LearningBoot.dto.OrderGoodsDto;
import com.fullSpring.LearningBoot.entity.Goods;
import com.fullSpring.LearningBoot.entity.Order;
import com.fullSpring.LearningBoot.entity.OrderGoodsPk;
import com.fullSpring.LearningBoot.entity.OrderGoodsWithFk;
import com.fullSpring.LearningBoot.repository.OrderGoodsWithFkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class OrderGoodsWithFkController {

    @Autowired
    private OrderGoodsWithFkRepository orderGoodsWithFkRepository;

    @PostMapping("ordergoodswithfk/get")
    public OrderGoodsDto get(
            @RequestBody GetOrderGoodsDto getOrderGoodsDto
    ) {
//ตรวจสอบว่ามี Order และ Goods ที่ระบุอยู่ในฐานข้อมูลหรือไม่
        OrderGoodsWithFk orderGoodsWithFk  = orderGoodsWithFkRepository.findById(
                new OrderGoodsPk().setGoodsId(getOrderGoodsDto.getGoodsId())
                        .setOrderId(getOrderGoodsDto.getOrderId())
        ).orElseThrow();
//บอกรูปเบบข้อมูลที่ต้องการส่งกลับ
        return new OrderGoodsDto()
                .setGoodsId(orderGoodsWithFk.getId().getGoodsId())
                .setOrderId(orderGoodsWithFk.getId().getOrderId())
                .setNumberOfPiece(orderGoodsWithFk.getNumberOfPiece())
                .setSum(orderGoodsWithFk.getSum())
                .setPricePerPiece(orderGoodsWithFk.getPricePerPiece());
    }


    @PostMapping("ordergoodswithfk/insert")
    public OrderGoodsDto insert(
            @RequestBody InsertOrderGoodsDto insertOrderGoodsDto
    ) {
        //ตรวจสอบว่ามี Order และ Goods ที่ระบุอยู่ในฐานข้อมูลหรือไม่
        OrderGoodsWithFk orderGoodsWithFk = new OrderGoodsWithFk()
                .setId(new OrderGoodsPk())
                .setGoods(new Goods().setGoodsId(insertOrderGoodsDto.getGoodsId()))
                .setOrder(new Order().setOrderId(insertOrderGoodsDto.getOrderId()))
                .setSum(BigDecimal.valueOf(insertOrderGoodsDto.getSum()))
                .setNumberOfPiece(insertOrderGoodsDto.getNumberOfPiece())
                .setPricePerPiece(BigDecimal.valueOf(insertOrderGoodsDto.getPricePerPiece()));
        orderGoodsWithFk = orderGoodsWithFkRepository.save(orderGoodsWithFk);

        //บอกรูปเบบข้อมูลที่ต้องการส่งกลับ
        return new OrderGoodsDto()
                .setGoodsId(orderGoodsWithFk.getId().getGoodsId())
                .setOrderId(orderGoodsWithFk.getId().getOrderId())
                .setNumberOfPiece(orderGoodsWithFk.getNumberOfPiece())
                .setSum(orderGoodsWithFk.getSum())
                .setPricePerPiece(orderGoodsWithFk.getPricePerPiece());
    }


}