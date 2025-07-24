package com.fullSpring.LearningBoot;

import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PutMapping("/hello2")
    public String helloPut() {
        return "Hello, World! This is a PUT request.";
    }

    @RequestMapping(value = "/hello3",method = {
            RequestMethod.GET,
            RequestMethod.POST
    })
    public String defaultMapping() {
        return "This is a default mapping response.";
    }

}
