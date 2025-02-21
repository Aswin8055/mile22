package com.examly.springapp.service;

import com.examly.springapp.model.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
    List<Comment> getCommentsByPostId(Long postId);
    List<Comment> getCommentsByUserId(Long userId);
    Comment createComment(Comment comment);
    Comment updateComment(Long id, Comment comment);
    void deleteComment(Long id);
    }