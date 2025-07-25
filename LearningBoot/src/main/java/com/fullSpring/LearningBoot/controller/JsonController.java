package com.fullSpring.LearningBoot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {
    @GetMapping("/test-json")
    public UserData getUserData() {
        UserData userData = new UserData();
        userData.setFirstName("John");
        userData.setLastName("Doe");
        return userData;
    }

    @GetMapping("/test-401")
    public ResponseEntity<Object> returnStatus401(@RequestParam String input){

        if (input.equals("hacker")){
            ErrorObject errorObject = new ErrorObject();
            errorObject.setErrorMessage("Hacker try to hack");
            return ResponseEntity.status(401).body(errorObject);
        }else {
            UserData userData = new UserData();
            userData.setFirstName("John");
            userData.setLastName("Doe");
            return ResponseEntity.ok(userData);
        }
    }
}
