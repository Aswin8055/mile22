package com.examly.springapp.model;

public class Comment {
    private Long id;
    private String content;
    private String createdDate;
    private Long userId;
    private Long postId;

    // Default constructor
    public Comment() {
    }

    // Parameterized constructor
    public Comment(Long id, String content, String createdDate, Long userId, Long postId) {
        this.id = id;
        this.content = content;
        this.createdDate = createdDate;
        this.userId = userId;
        this.postId = postId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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
}