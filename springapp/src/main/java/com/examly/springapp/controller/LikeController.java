// LikeController.java
package com.examly.springapp.controller;

import com.examly.springapp.model.Like;
import com.examly.springapp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.getAllLikes();
    }

    @PostMapping
    public Like createLike(@RequestBody Like like) {
        return likeService.createLike(like);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
    }
}