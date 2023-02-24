package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.repositories.CommentRepositories;
import com.training.bloggingsite.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepositories repositories;
    @Override
    public Comment addComment(Comment comment) {
        return repositories.save(comment);
    }

    @Override
    public void deleteComment(long id) {
        repositories.deleteById(id);
    }

    @Override
    public List<Comment> getCommentByUser(long userId) {
        List<Comment> list = new ArrayList<>();
//        for ()
//        return repositories.findAllById(userId);
        return null;
    }

    @Override
    public List<Comment> getCommentByPost() {
        return null;
    }

    @Override
    public List<Comment> getVerifiedComments() {
        return null;
    }

    @Override
    public List<Comment> getUnverifiedComments() {
        return null;
    }

}
