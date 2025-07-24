package com.fullSpring.LearningBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariabelController {

    @GetMapping("/posts/{id}")
    public String getPostId(@PathVariable("id") String postId) {
        System.out.println("Post ID: " + postId);
        return "Post ID: " + postId;
    }
    @GetMapping("/posts2/{id}/comments/{commentId}")
    public String getPostId2(@PathVariable("id") String postId,
                             @PathVariable("commentId") String commentId) {
        System.out.println("Post ID: " + postId);
        System.out.println("Comment ID: " + commentId);
        return "Post ID: " + postId + ", Comment ID: " + commentId;
    }
}
