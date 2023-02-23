package com.training.bloggingsite.services;

import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.repositories.CommentRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepositories repositories;
    @Override
    @Transactional
    public Comment addComment(Comment comment) {
        return repositories.save(comment);
    }

    @Override
    @Transactional
    public void deleteComment(long id) {
        repositories.deleteById(id);
    }

    @Override
    @Transactional
    public List<Comment> getCommentByUser() {
        return null;
    }

    @Override
    @Transactional
    public List<Comment> getCommentByPost() {
        return null;
    }

    @Override
    @Transactional
    public List<Comment> getVerifiedComments() {
        return null;
    }

    @Override
    @Transactional
    public List<Comment> getUnverifiedComments() {
        return null;
    }
}
