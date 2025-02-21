package com.examly.springapp.service;

import com.examly.springapp.model.Like;
import java.util.List;

public interface LikeService {
    List<Like> getAllLikes();
    Like getLikeById(Long id);
    List<Like> getLikesByPostId(Long postId);
    List<Like> getLikesByUserId(Long userId);
    Like createLike(Like like);
    void deleteLike(Long id);
}