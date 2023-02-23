package com.training.bloggingsite.services;

import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.repositories.CommentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

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
    @Transactional
    public List<Comment> getCommentByUser(long userId) {
        List<Comment> commentByUser = new ArrayList<>();
//        repositories.findAllById(userId);
        return commentByUser;
    }

    @Override
    public List<Comment> getCommentByPost() {
        List<Comment> comentByPost = new ArrayList<>();
//        repositories.findAllById()
        return comentByPost;
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
