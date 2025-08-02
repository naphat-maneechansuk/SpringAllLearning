package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.dto.AddressDto;
import com.fullSpring.LearningBoot.dto.InsertAddressDto;
import com.fullSpring.LearningBoot.entity.Address;
import com.fullSpring.LearningBoot.entity.User;
import com.fullSpring.LearningBoot.repository.AddressRepository;
import com.fullSpring.LearningBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public AddressDto getAddress(@PathVariable("userId") String userId){
        Address address = addressRepository.findById(userId).orElseThrow();
        return new AddressDto().
                setUserId(address.getUser().getUserId())
                .setUserName(address.getUser().getUserName())
                .setHouseNo(address.getHouseNo())
                .setSubDistrict(address.getSubDistrict())
                .setDistrict(address.getDistrict())
                .setCity(address.getCity())
                .setPostcode(address.getPostcode());
    }
//ใช้ไม่ได้
//    @PostMapping("/insertAddress")
//    public AddressDto insertAddress(@RequestBody InsertAddressDto insertAddressDto) {
//        User user =userRepository.findById(insertAddressDto.getUserId()).orElseThrow();
//        Address address = new Address()
//                .setUser(user)
//                .setHouseNo(insertAddressDto.getHouseNo())
//                .setSubDistrict(insertAddressDto.getSubDistrict())
//                .setDistrict(insertAddressDto.getDistrict())
//                .setCity(insertAddressDto.getCity())
//                .setPostcode(insertAddressDto.getPostcode());
//        addressRepository.save(address);
//        return new AddressDto()
//                .setUserId(address.getUserId())
//                .setUserName(address.getUser().getUserName())
//                .setHouseNo(address.getHouseNo())
//                .setSubDistrict(address.getSubDistrict())
//                .setDistrict(address.getDistrict())
//                .setCity(address.getCity())
//                .setPostcode(address.getPostcode());
//    }
    //ใชไม่ได้

}
