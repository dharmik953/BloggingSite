package com.training.bloggingsite.dtos;

public class CommentDto {

    private String commentContent;

    private long commentId;

    public CommentDto(String commentContent, long commentId) {
        this.commentContent = commentContent;
        this.commentId = commentId;
    }

    public CommentDto() {
    }
}
