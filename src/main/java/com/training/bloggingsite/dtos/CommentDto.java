package com.training.bloggingsite.dtos;

import java.time.LocalDateTime;

public class CommentDto {

    private long commentIdDto;

    private boolean isVerifiedCommentDto = false;

    private LocalDateTime createDateTimeCommentDto;

    private LocalDateTime updateDateTimeCommentDto;
    private String commentContentDto;

    @Override
    public String toString() {
        return "CommentDto{" +
                "commentIdDto=" + commentIdDto +
                ", isVerifiedCommentDto=" + isVerifiedCommentDto +
                ", createDateTimeCommentDto=" + createDateTimeCommentDto +
                ", updateDateTimeCommentDto=" + updateDateTimeCommentDto +
                ", commentContentDto='" + commentContentDto + '\'' +
                '}';
    }

    public long getCommentIdDto() {
        return commentIdDto;
    }

    public void setCommentIdDto(long commentIdDto) {
        this.commentIdDto = commentIdDto;
    }

    public boolean isVerifiedCommentDto() {
        return isVerifiedCommentDto;
    }

    public void setVerifiedCommentDto(boolean verifiedCommentDto) {
        isVerifiedCommentDto = verifiedCommentDto;
    }

    public LocalDateTime getCreateDateTimeCommentDto() {
        return createDateTimeCommentDto;
    }

    public void setCreateDateTimeCommentDto(LocalDateTime createDateTimeCommentDto) {
        this.createDateTimeCommentDto = createDateTimeCommentDto;
    }

    public LocalDateTime getUpdateDateTimeCommentDto() {
        return updateDateTimeCommentDto;
    }

    public void setUpdateDateTimeCommentDto(LocalDateTime updateDateTimeCommentDto) {
        this.updateDateTimeCommentDto = updateDateTimeCommentDto;
    }

    public String getCommentContentDto() {
        return commentContentDto;
    }

    public void setCommentContentDto(String commentContentDto) {
        this.commentContentDto = commentContentDto;
    }

    public CommentDto() {
    }

    public CommentDto(long commentIdDto, boolean isVerifiedCommentDto, LocalDateTime createDateTimeCommentDto, LocalDateTime updateDateTimeCommentDto, String commentContentDto) {
        this.commentIdDto = commentIdDto;
        this.isVerifiedCommentDto = isVerifiedCommentDto;
        this.createDateTimeCommentDto = createDateTimeCommentDto;
        this.updateDateTimeCommentDto = updateDateTimeCommentDto;
        this.commentContentDto = commentContentDto;
    }
}
