package com.examly.springapp.repository;

import com.examly.springapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}