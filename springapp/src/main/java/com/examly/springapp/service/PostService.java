package com.examly.springapp.service;

import com.examly.springapp.model.Post;
import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    List<Post> getPostsByUserId(Long userId);
    Post createPost(Post post);
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}