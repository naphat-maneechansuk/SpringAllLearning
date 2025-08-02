package com.fullSpring.LearningBoot.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class InsertOrderGoodsDto {
    private String orderId;
    private String goodsId;
    private Integer numberOfPiece;
    private Double pricePerPiece;
    private Double sum;
}
