package com.example.social.controller;

import com.example.social.model.Post;
import com.example.social.service.FeedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedController {
    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/{userId}")
    public List<Post> getFeed(@PathVariable Long userId) {
        return feedService.getFeed(userId);
    }
}
