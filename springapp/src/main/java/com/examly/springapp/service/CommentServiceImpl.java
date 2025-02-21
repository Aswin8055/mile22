package com.examly.springapp.service;

import com.examly.springapp.model.Comment;
import com.examly.springapp.repository.CommentRepository;
import com.examly.springapp.service.CommentService;
import com.examly.springapp.service.PostService;
import com.examly.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public List<Comment> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    @Override
    public Comment createComment(Comment comment) {
        if (comment.getCreatedDate() == null) {
            comment.setCreatedDate(LocalDate.now().toString());
        }
        comment.setUser(userService.getUserById(comment.getUserId()));
        comment.setPost(postService.getPostById(comment.getPostId()));
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = getCommentById(id);

        if (commentDetails.getContent() != null) {
            comment.setContent(commentDetails.getContent());
        }

        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = getCommentById(id);
        commentRepository.delete(comment);
    }
}