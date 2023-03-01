package com.training.bloggingsite.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment extends BaseEntity {

    private boolean isVerified = false;

    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;


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
                ", postId=" + post +
                ", userId=" + user +
                '}';
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
