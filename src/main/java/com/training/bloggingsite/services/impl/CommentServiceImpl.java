package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.repositories.CommentRepository;
import com.training.bloggingsite.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository repositories;

    List<CommentDto> verifiedComment = new ArrayList<>();
    List<CommentDto> unVerifiedComment = new ArrayList<>();

    @Override
    public Comment addComment(Comment comment) {
        return repositories.save(comment);
    }

    @Override
    public void deleteComment(long id) {
        repositories.deleteById(id);
    }

    @Override
    public List<CommentDto> getCommentByUser(long userId) {
        List<Comment> list = new ArrayList<>();
//        for ()
//        return repositories.findAllById(userId);
        return null;
    }

    @Override
    public List<CommentDto> getCommentByPost(long postId) {
        return null;
    }

    @Override
    public List<CommentDto> getVerifiedComments() {
        return null;
    }

    @Override
    public List<CommentDto> getUnverifiedComments() {
        return null;
    }

}
