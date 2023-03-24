package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.CommentDto;

import java.util.List;

public interface CommentService {

    String addComment(CommentDto comment,long postId,String userEmail);

    List<CommentDto> findCommentByPostVerified(Long postId);

    List<CommentDto> findAllCommentsByPostId(long postId);

    void updateVerification(Long commentId, Boolean isVerified);

    String redirectToPost(String email, long postId);
}
