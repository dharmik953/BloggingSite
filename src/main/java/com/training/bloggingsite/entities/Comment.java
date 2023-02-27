package com.training.bloggingsite.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "column_id")
    private long id;

    private boolean isVerified = false;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    private String commentContent;

    private Long postId;
    private Long userId;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + id +
                ", isVerified=" + isVerified +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                ", commentContent='" + commentContent + '\'' +
                ", postId=" + postId +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long commentId) {
        this.id = commentId;
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

    public Comment() {
    }

    public Comment(long id, boolean isVerified, LocalDateTime createDateTime, LocalDateTime updateDateTime, String commentContent) {
        this.id = id;
        this.isVerified = isVerified;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.commentContent = commentContent;
    }

    public void setPostId(Long postId) {
        Post post = new Post();
        post.setId(postId);
    }
}
