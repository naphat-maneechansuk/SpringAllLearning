package com.fullSpring.LearningBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class GoodsDto {

    private String goodsId;
    private String goodsName;
    private Double goodsPrice;
    private String shopId;
    private String shopName;

}
