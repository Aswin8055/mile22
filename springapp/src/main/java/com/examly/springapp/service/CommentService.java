package com.examly.springapp.service;

import com.examly.springapp.model.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    Comment createComment(Comment comment);
    Comment updateComment(Long id, Comment comment);
    void deleteComment(Long id);
    Comment getCommentById(Long id);
}