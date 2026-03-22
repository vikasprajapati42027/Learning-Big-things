package com.example.social.repository;

import com.example.social.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findTop50ByUserIdInOrderByCreatedAtDesc(List<Long> userIds);
}
