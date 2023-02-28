package com.training.bloggingsite.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment extends BaseEntity {

    private boolean isVerified = false;

    private Long postId;
    private Long userId;

    public Comment(long commentIdDto, boolean verifiedCommentDto, LocalDateTime createDateTimeCommentDto, LocalDateTime updateDateTimeCommentDto, String commentContentDto) {
        super();
    }


    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }


    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "isVerified=" + isVerified +
                ", postId=" + postId +
                ", userId=" + userId +
                '}';
    }

    public void setPostId(Long postId) {
        Post post = new Post();
        post.setId(postId);
    }
}
