package com.fullSpring.LearningBoot.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class AddressDto {

    private String userId;
    private String userName;
    private String houseNo;
    private String subDistrict;
    private String district;
    private String city;
    private String postcode;
}
