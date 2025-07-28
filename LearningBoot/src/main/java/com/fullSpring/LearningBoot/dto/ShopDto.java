package com.fullSpring.LearningBoot.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class ShopDto {
    private String shopId;
    private String shopName;


}
