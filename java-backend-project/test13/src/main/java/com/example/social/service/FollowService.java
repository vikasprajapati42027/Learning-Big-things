package com.example.social.service;

import com.example.social.dto.FollowRequest;
import com.example.social.model.Follow;
import com.example.social.repository.FollowRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowService {
    private final FollowRepository followRepository;

    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @CacheEvict(value = "feed", key = "#request.followerId")
    public Follow follow(FollowRequest request) {
        Follow f = new Follow();
        f.setFollowerId(request.getFollowerId());
        f.setFolloweeId(request.getFolloweeId());
        return followRepository.save(f);
    }

    @CacheEvict(value = "feed", key = "#followerId")
    public void unfollow(Long followerId, Long followeeId) {
        followRepository.deleteByFollowerIdAndFolloweeId(followerId, followeeId);
    }

    public List<Long> followees(Long followerId) {
        return followRepository.findByFollowerId(followerId)
                .stream()
                .map(Follow::getFolloweeId)
                .collect(Collectors.toList());
    }
}
