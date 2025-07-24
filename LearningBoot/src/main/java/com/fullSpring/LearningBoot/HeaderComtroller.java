package com.fullSpring.LearningBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HeaderComtroller {

    @GetMapping("/test-header")
    public String getHeader(@RequestHeader("Accept-Encoding") String headerFormRequest) {
        System.out.println("Header Value: " + headerFormRequest);
        return headerFormRequest;
    }

    @GetMapping("/test-header2")
    public String getHeader2(
            @RequestHeader Map<String , String> headers
            ){
        return headers.get("Accept-Encoding".toLowerCase());
    }
}
