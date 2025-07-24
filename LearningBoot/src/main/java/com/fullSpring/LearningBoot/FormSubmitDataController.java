package com.fullSpring.LearningBoot;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormSubmitDataController {

    @PostMapping("/login")
    public String login(@ModelAttribute UserCredential inputFromSubmit) {
        System.out.println("Username: " + inputFromSubmit.getUsername());
        System.out.println("Password: " + inputFromSubmit.getPassword());

        return "";
    }
}
