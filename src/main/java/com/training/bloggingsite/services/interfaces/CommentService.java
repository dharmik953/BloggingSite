package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.entities.Comment;

import java.util.List;

public interface CommentService {
    void addComment(CommentDto comment,long postId,String userEmail);

    public void deleteComment(long id);

    List<CommentDto> getCommentByUser(long userId);
    List<CommentDto> getCommentByPost(long postId);
    List<CommentDto> getVerifiedComments();
    List<CommentDto> getUnverifiedComments();


}
