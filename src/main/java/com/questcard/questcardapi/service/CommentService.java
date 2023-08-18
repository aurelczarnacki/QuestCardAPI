package com.questcard.questcardapi.service;

import com.questcard.questcardapi.model.entity.Comment;
import com.questcard.questcardapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public List<Comment> getCommentsByQuizId(Long quizId) {
        // Implement your logic here to retrieve comments by quizId
        // For example: return commentRepository.findByQuizQuizId(quizId);
        return null;
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, Comment updatedComment) {
        Comment existingComment = commentRepository.findById(commentId).orElse(null);
        if (existingComment != null) {
            // Update properties of existingComment using updatedComment
            // For example: existingComment.setText(updatedComment.getText());
            return commentRepository.save(existingComment);
        }
        return null;
    }

    public boolean deleteComment(Long commentId) {
        Comment existingComment = commentRepository.findById(commentId).orElse(null);
        if (existingComment != null) {
            commentRepository.delete(existingComment);
            return true;
        }
        return false;
    }
}