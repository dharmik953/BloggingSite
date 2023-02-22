package com.training.bloggingsite.services;

import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);

    public void deleteComment(long id);

    List<Comment> getCommentByUser();
    List<Comment> getCommentByPost();
    List<Comment> getVerifiedComments();
    List<Comment> getUnverifiedComments();
}
