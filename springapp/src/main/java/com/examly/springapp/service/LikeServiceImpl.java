package com.examly.springapp.service;

import com.examly.springapp.model.Like;
import com.examly.springapp.service.LikeService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    private List<Like> likes = new ArrayList<>();

    @Override
    public List<Like> getAllLikes() {
        return likes;
    }

    @Override
    public Like createLike(Like like) {
        likes.add(like);
        return like;
    }

    @Override
    public void deleteLike(Long id) {
        likes.removeIf(like -> like.getId().equals(id));
    }

    @Override
    public Like getLikeById(Long id) {
        return likes.stream()
                .filter(like -> like.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}