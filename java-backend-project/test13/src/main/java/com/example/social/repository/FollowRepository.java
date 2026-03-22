package com.example.social.repository;

import com.example.social.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFollowerId(Long followerId);
    void deleteByFollowerIdAndFolloweeId(Long followerId, Long followeeId);
}
