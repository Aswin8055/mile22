package com.examly.springapp.service;

import com.examly.springapp.model.Post;
import com.examly.springapp.service.PostService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> getAllPosts() {
        return posts;
    }

    @Override
    public Post createPost(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public Post updatePost(Long id, Post post) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(id)) {
                posts.set(i, post);
                return post;
            }
        }
        return null;
    }

    @Override
    public void deletePost(Long id) {
        posts.removeIf(post -> post.getId().equals(id));
    }

    @Override
    public Post getPostById(Long id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}