package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.dto.GetOrderGoodsDto;
import com.fullSpring.LearningBoot.dto.InsertOrderGoodsDto;
import com.fullSpring.LearningBoot.dto.OrderGoodsDto;
import com.fullSpring.LearningBoot.entity.OrderGoodsNoFk;
import com.fullSpring.LearningBoot.entity.OrderGoodsPk;
import com.fullSpring.LearningBoot.repository.OrderGoodsNoFkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequestMapping("/orderGoodsNoFk")
@RestController
public class OrderGoodsNoFkController {
    @Autowired
    private OrderGoodsNoFkRepository orderGoodsNoFkRepository;

    @PostMapping("/get")
    public OrderGoodsDto getOrderGoods(@RequestBody GetOrderGoodsDto getOrderGoodsDto) {
        // ตรวจสอบว่ามี Order และ Goods ที่ระบุอยู่ในฐานข้อมูลหรือไม่
        OrderGoodsNoFk orderGoodsNoFk = orderGoodsNoFkRepository.findById(
                new OrderGoodsPk().setGoodsId(getOrderGoodsDto.getGoodsId())
                        .setOrderId(getOrderGoodsDto.getOrderId())
        ).orElseThrow();
        // บอกรูปแบบข้อมูลที่ต้องการส่งกลับ
        return new OrderGoodsDto()
                .setOrderId(orderGoodsNoFk.getOrderGoodsPk().getOrderId())
                .setGoodsId(orderGoodsNoFk.getOrderGoodsPk().getGoodsId())
                .setNumberOfPiece(orderGoodsNoFk.getNumberOfPiece())
                .setPricePerPiece(orderGoodsNoFk.getPricePerPiece())
                .setSum(orderGoodsNoFk.getSum());
    }

    @PostMapping("/insert")
    public OrderGoodsDto insertOrderGoods(@RequestBody InsertOrderGoodsDto insertOrderGoodsDto){
        // ตรวจสอบว่ามี Order และ Goods ที่ระบุอยู่ในฐานข้อมูลหรือไม่
        OrderGoodsNoFk orderGoodsNoFk = new OrderGoodsNoFk()
                .setOrderGoodsPk(new OrderGoodsPk()
                        .setOrderId(insertOrderGoodsDto.getOrderId())
                        .setGoodsId(insertOrderGoodsDto.getGoodsId())
                )
                .setSum(BigDecimal.valueOf(insertOrderGoodsDto.getSum()))
                .setNumberOfPiece(insertOrderGoodsDto.getNumberOfPiece())
                .setPricePerPiece(BigDecimal.valueOf(insertOrderGoodsDto.getPricePerPiece()));
        orderGoodsNoFk = orderGoodsNoFkRepository.save(orderGoodsNoFk);

        // บอกรูปแบบข้อมูลที่ต้องการส่งกลับ
        return new OrderGoodsDto()
                .setOrderId(orderGoodsNoFk.getOrderGoodsPk().getOrderId())
                .setGoodsId(orderGoodsNoFk.getOrderGoodsPk().getGoodsId())
                .setNumberOfPiece(orderGoodsNoFk.getNumberOfPiece())
                .setPricePerPiece(orderGoodsNoFk.getPricePerPiece())
                .setSum(orderGoodsNoFk.getSum());
    }
}
