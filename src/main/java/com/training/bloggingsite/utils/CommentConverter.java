package com.training.bloggingsite.utils;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.entities.Comment;

public class CommentConverter {

    public static Comment toComment(CommentDto commentDto){
        return new Comment(
               commentDto.getId(),
                commentDto.getContent(),commentDto.isVerified(),
                UserConvertor.toUser(commentDto.getUserDto()),
                PostConvertor.toPost(commentDto.getPostDto()), commentDto.getCreateDateTime(), commentDto.getUpdateDateTime()
        );
    }

    public static CommentDto toCommentDto(Comment comment){
        return new CommentDto(
              comment.getId(),
                comment.getContent(),
                UserConvertor.toUserDto(comment.getUser()),
                PostConvertor.toPostDto(comment.getPost()), comment.isVerified(), comment.getCreatedDateTime(), comment.getUpdatedDateTime()
        );
    }
}
