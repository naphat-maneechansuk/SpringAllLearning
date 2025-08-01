package com.fullSpring.LearningBoot.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class GoodsDto {

    private String goodsId;
    private String goodsName;
    private Double goodsPrice;
    private String shopId;
    private String shopName;

}
