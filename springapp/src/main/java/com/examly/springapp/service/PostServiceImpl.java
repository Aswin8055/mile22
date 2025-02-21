package com.examly.springapp.service;

import com.examly.springapp.model.Post;
import com.examly.springapp.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    // In-memory storage for posts
    private final Map<Long, Post> posts = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Post getPostById(Long id) {
        return posts.get(id);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return posts.values().stream()
                .filter(post -> post.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Post createPost(Post post) {
        // Generate new ID if not provided
        if (post.getId() == null) {
            post.setId(nextId++);
        }

        // Set creation date if not provided
        if (post.getCreatedDate() == null) {
            post.setCreatedDate(LocalDate.now().toString());
        }

        posts.put(post.getId(), post);
        return post;
    }

    @Override
    public Post updatePost(Long id, Post post) {
        if (!posts.containsKey(id)) {
            return null;
        }

        Post existingPost = posts.get(id);

        if (post.getContent() != null) {
            existingPost.setContent(post.getContent());
        }
        if (post.getImageUrl() != null) {
            existingPost.setImageUrl(post.getImageUrl());
        }

        return existingPost;
    }

    @Override
    public void deletePost(Long id) {
        posts.remove(id);
    }
}