package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);

    public void deleteComment(long id);

    List<Comment> getCommentByUser(long userId);
    List<Comment> getCommentByPost();
    List<Comment> getVerifiedComments();
    List<Comment> getUnverifiedComments();

    default Comment toCategory(CommentDto commentDto){
        return new Comment(
                commentDto.getCommentId(),
                commentDto.isVerified(),
                commentDto.getUpdateDateTime(),
                commentDto.getCreateDateTime(),
                commentDto.getCommentContent()
        );
    }

    default CommentDto toCategoryDto(Comment comment){
        return new CommentDto(
                comment.getCommentId(),
                comment.isVerified(),
                comment.getUpdateDateTime(),
                comment.getCreateDateTime(),
                comment.getCommentContent()
        );
    }
}
