package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.CommentDto;
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
        List<Comment> comments = this.repositories.findByUserId(userId);
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment:comments) {
            commentDtos.add(toCommentDto(comment));
        }
        return commentDtos;
    }

    @Override
    public List<CommentDto> getCommentByPost(long postId) {
        List<Comment> comments = this.repositories.findByPostId(postId);
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment:comments) {
            commentDtos.add(toCommentDto(comment));
        }
        return commentDtos;
    }

    @Override
    public List<CommentDto> getVerifiedComments() {

        for (Comment comment: repositories.findAll()) {
            if (comment.isVerified()){
                verifiedComment.add(toCommentDto(comment));
            } else {
                unVerifiedComment.add(toCommentDto(comment));
            }
        }
        return verifiedComment;
    }

    @Override
    public List<CommentDto> getUnverifiedComments() {
        return unVerifiedComment;
    }

}
