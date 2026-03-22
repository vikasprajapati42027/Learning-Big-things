package com.example.social.service;

import com.example.social.dto.CreatePostRequest;
import com.example.social.model.Post;
import com.example.social.repository.PostRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @CacheEvict(value = "feed", key = "#request.userId")
    public Post create(CreatePostRequest request) {
        Post post = new Post();
        post.setUserId(request.getUserId());
        post.setContent(request.getContent());
        post.setCreatedAt(OffsetDateTime.now());
        return postRepository.save(post);
    }

    public List<Post> listRecentByUsers(List<Long> userIds) {
        if (userIds == null || userIds.isEmpty()) return List.of();
        return postRepository.findTop50ByUserIdInOrderByCreatedAtDesc(userIds);
    }
}
