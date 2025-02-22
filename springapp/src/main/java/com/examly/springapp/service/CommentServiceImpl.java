package com.examly.springapp.service;

import com.examly.springapp.model.Comment;
import com.examly.springapp.service.CommentService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private List<Comment> comments = new ArrayList<>();

    @Override
    public List<Comment> getAllComments() {
        return comments;
    }

    @Override
    public Comment createComment(Comment comment) {
        comments.add(comment);
        return comment;
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId().equals(id)) {
                comments.set(i, comment);
                return comment;
            }
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        comments.removeIf(comment -> comment.getId().equals(id));
    }

    @Override
    public Comment getCommentById(Long id) {
        return comments.stream()
                .filter(comment -> comment.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}