package com.examly.springapp.model;

public class Post {
    private Long id;
    private String content;
    private String imageUrl;
    private String createdDate;
    private Long userId;

    // Default constructor
    public Post() {
    }

    // Parameterized constructor
    public Post(Long id, String content, String imageUrl, String createdDate, Long userId) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        this.createdDate = createdDate;
        this.userId = userId;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}