package com.example.social.controller;

import com.example.social.dto.CreatePostRequest;
import com.example.social.model.Post;
import com.example.social.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody @Valid CreatePostRequest request) {
        return postService.create(request);
    }
}
