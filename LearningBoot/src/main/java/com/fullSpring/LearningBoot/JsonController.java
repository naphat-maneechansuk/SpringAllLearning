package com.fullSpring.LearningBoot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @PostMapping("/loginJson")
    public String loginWithJson(@RequestBody UserCredential inputJson) {
        return "Username: " + inputJson.getUsername() + ", Password: " + inputJson.getPassword();
    }
}
