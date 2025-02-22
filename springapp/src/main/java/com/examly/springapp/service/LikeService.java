package com.examly.springapp.service;

import com.examly.springapp.model.Like;
import java.util.List;

public interface LikeService {
    List<Like> getAllLikes();

    Like createLike(Like like);

    void deleteLike(Long id);

    Like getLikeById(Long id);
}