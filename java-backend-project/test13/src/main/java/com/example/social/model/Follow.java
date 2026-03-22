package com.example.social.model;

import jakarta.persistence.*;

@Entity
@Table(name = "follows", uniqueConstraints = @UniqueConstraint(columnNames = {"follower_id","followee_id"}))
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "follower_id", nullable = false)
    private Long followerId;

    @Column(name = "followee_id", nullable = false)
    private Long followeeId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getFollowerId() { return followerId; }
    public void setFollowerId(Long followerId) { this.followerId = followerId; }
    public Long getFolloweeId() { return followeeId; }
    public void setFolloweeId(Long followeeId) { this.followeeId = followeeId; }
}
