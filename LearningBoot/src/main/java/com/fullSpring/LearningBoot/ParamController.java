package com.fullSpring.LearningBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamController {
    @GetMapping("/test")
    public String mappingTest(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", defaultValue = "18") int age) {
        return  "Hello, " + (name != null ? name : "Guest") + "! You are " + age + " years old.";
    }
}
