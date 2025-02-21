package com.examly.springapp.model;

public class Like {
    private Long id;
    private Long userId;
    private Long postId;
    private String createdDate;

    // Default constructor
    public Like() {
    }

    // Parameterized constructor
    public Like(Long id, Long userId, Long postId, String createdDate) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}