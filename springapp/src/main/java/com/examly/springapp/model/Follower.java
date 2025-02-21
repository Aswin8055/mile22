package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "followers")
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    @Column(name = "follower_id", insertable = false, updatable = false)
    private Long followerId;

    @ManyToOne
    @JoinColumn(name = "following_id")
    private User following;

    @Column(name = "following_id", insertable = false, updatable = false)
    private Long followingId;

    private String createdDate;

    // Constructors
    public Follower() {
    }

    public Follower(Long id, Long followerId, Long followingId, String createdDate) {
        this.id = id;
        this.followerId = followerId;
        this.followingId = followingId;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public User getFollowing() {
        return following;
    }

    public void setFollowing(User following) {
        this.following = following;
    }

    public Long getFollowingId() {
        return followingId;
    }

    public void setFollowingId(Long followingId) {
        this.followingId = followingId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}