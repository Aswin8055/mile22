package com.examly.springapp.model;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Post> posts;
    private List<Comment> comments;
    private List<Like> likes;
    private String profilePicture;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(Long id, String name, String email, String password, List<Post> posts, List<Comment> comments,
            List<Like> likes, String profilePicture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.comments = comments;
        this.likes = likes;
        this.profilePicture = profilePicture;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}