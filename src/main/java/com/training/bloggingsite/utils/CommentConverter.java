package com.training.bloggingsite.utils;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.entities.Comment;

public class CommentConverter {

    public static Comment toComment(CommentDto commentDto){
        return new Comment(
                commentDto.getIdDto(),
                commentDto.isVerifiedCommentDto(),
                commentDto.getCreateDateTimeCommentDto(),
                commentDto.getUpdateDateTimeCommentDto(),
                commentDto.getNameDto()
        );
    }

    public static CommentDto toCommentDto(Comment comment){
        return new CommentDto(
                comment.getId(),
                comment.isVerified(),
                comment.getUpdateDateTime(),
                comment.getCreateDateTime(),
                comment.getName()
        );
    }
}
