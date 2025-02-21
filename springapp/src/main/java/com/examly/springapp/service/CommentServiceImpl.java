package com.examly.springapp.service.impl;

import com.examly.springapp.model.Comment;
import com.examly.springapp.service.CommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    // In-memory storage for comments
    private final Map<Long, Comment> comments = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<Comment> getAllComments() {
        return new ArrayList<>(comments.values());
        }

        @Override
        public Comment getCommentById(Long id) {
            return comments.get(id);
        }

        @Override
        public List<Comment> getCommentsByPostId(Long postId) {
            return comments.values().stream()
            .filter(comment -> comment.getPostId().equals(postId))
            .collect(Collectors.toList());
            }

            @Override
            public List<Comment> getCommentsByUserId(Long userId) {
                return comments.values().stream()
                .filter(comment -> comment.getUserId().equals(userId))
                .collect(Collectors.toList());
            }

            @Override
            public Comment createComment(Comment comment) {
                // Generate new ID if not provided
                if (comment.getId() == null) {
                    comment.setId(nextId++);
                    }

                    // Set creation date if not provided
                    if (comment.getCreatedDate() == null) {
                        comment.setCreatedDate(LocalDate.now().toString());
                        }

                        comments.put(comment.getId(), comment);
                        return comment;
                    }

                    @Override
                    public Comment updateComment(Long id, Comment comment) {
                        if (!comments.containsKey(id)) {
                            return null;
                            }

                            Comment existingComment = comments.get(id);

                            if (comment.getContent() != null) {
                                existingComment.setContent(comment.getContent());
                                }

                                return existingComment;
                            }

                            @Override
                            public void deleteComment(Long id) {
                                comments.remove(id);
                            }
                            }