package com.examly.springapp.service;

import com.examly.springapp.model.Like;
import com.examly.springapp.service.LikeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {

    // In-memory storage for likes
    private final Map<Long, Like> likes = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<Like> getAllLikes() {
        return new ArrayList<>(likes.values());
    }

    @Override
    public Like getLikeById(Long id) {
        return likes.get(id);
    }

    @Override
    public List<Like> getLikesByPostId(Long postId) {
        return likes.values().stream()
                .filter(like -> like.getPostId().equals(postId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Like> getLikesByUserId(Long userId) {
        return likes.values().stream()
                .filter(like -> like.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Like createLike(Like like) {
        // Generate new ID if not provided
        if (like.getId() == null) {
            like.setId(nextId++);
        }

        // Set creation date if not provided
        if (like.getCreatedDate() == null) {
            like.setCreatedDate(LocalDate.now().toString());
        }

        likes.put(like.getId(), like);
        return like;
    }

    @Override
    public void deleteLike(Long id) {
        likes.remove(id);
    }
}