package com.training.bloggingsite.dtos;

import java.time.LocalDateTime;

public class CommentDto {

    private long commentId;

    private boolean isVerified = false;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;
    private String commentContent;

    public CommentDto(long commentId, boolean isVerified, LocalDateTime createDateTime, LocalDateTime updateDateTime, String commentContent) {
        this.commentId = commentId;
        this.isVerified = isVerified;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "commentId=" + commentId +
                ", isVerified=" + isVerified +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public CommentDto() {
    }
}
