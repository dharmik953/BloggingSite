package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);

    public void deleteComment(long id);

    List<CommentDto> getCommentByUser(long userId);
    List<CommentDto> getCommentByPost(long postId);
    List<CommentDto> getVerifiedComments();
    List<CommentDto> getUnverifiedComments();

    default Comment toComment(CommentDto commentDto){
        return new Comment(
                commentDto.getCommentIdDto(),
                commentDto.isVerifiedCommentDto(),
                commentDto.getCreateDateTimeCommentDto(),
                commentDto.getUpdateDateTimeCommentDto(),
                commentDto.getCommentContentDto()
        );
    }

    default CommentDto toCommentDto(Comment comment){
        return new CommentDto(
                comment.getId(),
                comment.isVerified(),
                comment.getUpdateDateTime(),
                comment.getCreateDateTime(),
                comment.getCommentContent()
        );
    }
}
