package com.examly.springapp.model;

import java.util.List;

public class Post {
    private Long id;
    private String content;
    private String imageUrl;
    private String createdDate;
    private Long userId;
    private List<Comment> comments;
    private List<Like> likes;

    // Default constructor
    public Post() {
    }

    // Constructor with basic fields
    public Post(Long id, String content, String imageUrl, String createdDate, Long userId) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        this.createdDate = createdDate;
        this.userId = userId;
    }

    // Full constructor
    public Post(Long id, String content, String imageUrl, String createdDate, Long userId, List<Comment> comments,
            List<Like> likes) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        this.createdDate = createdDate;
        this.userId = userId;
        this.comments = comments;
        this.likes = likes;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}