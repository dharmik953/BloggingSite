package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.entities.Comment;

import java.util.List;

public interface CommentService {

    String addComment(CommentDto comment,long postId,String userEmail);

    List<CommentDto> findCommentByPostVerified(long postId);

    List<CommentDto> findAllPost(long postId);

    void updateVerification(long commentId, boolean isVerified);
}
