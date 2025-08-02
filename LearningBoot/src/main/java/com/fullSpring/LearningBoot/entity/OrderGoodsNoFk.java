package com.fullSpring.LearningBoot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "order_goods")
public class OrderGoodsNoFk {

    @EmbeddedId
    private OrderGoodsPk orderGoodsPk;

    @Column(name = "number_of_piece")
    private Integer numberOfPiece;

    @Column(name = "price_per_piece")
    private BigDecimal pricePerPiece;

    @Column(name = "sum")
    private BigDecimal sum;
}
