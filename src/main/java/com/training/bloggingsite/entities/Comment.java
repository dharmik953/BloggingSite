package com.training.bloggingsite.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Comment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    String content;

    boolean isVerified;

    @ManyToOne
    User user;

    @ManyToOne
    Post post;

    @CreationTimestamp
    LocalDateTime createdDateTime;

    @UpdateTimestamp
    LocalDateTime updatedDateTime;

    public Comment(){}
    public Comment(long id, String content, boolean isVerified, User user, Post post, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
        Id = id;
        this.content = content;
        this.isVerified = isVerified;
        this.user = user;
        this.post = post;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
