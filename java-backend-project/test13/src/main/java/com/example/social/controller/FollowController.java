package com.example.social.controller;

import com.example.social.dto.FollowRequest;
import com.example.social.model.Follow;
import com.example.social.service.FollowService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follows")
public class FollowController {
    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Follow follow(@RequestBody @Valid FollowRequest request) {
        return followService.follow(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unfollow(@RequestParam Long followerId, @RequestParam Long followeeId) {
        followService.unfollow(followerId, followeeId);
    }
}
