package com.example.social.service;

import com.example.social.model.Post;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {
    private final FollowService followService;
    private final PostService postService;

    public FeedService(FollowService followService, PostService postService) {
        this.followService = followService;
        this.postService = postService;
    }

    @Cacheable(value = "feed", key = "#userId")
    public List<Post> getFeed(Long userId) {
        List<Long> ids = new ArrayList<>();
        ids.add(userId);
        ids.addAll(followService.followees(userId));
        return postService.listRecentByUsers(ids);
    }
}
