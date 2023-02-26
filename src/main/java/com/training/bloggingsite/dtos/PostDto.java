package com.training.bloggingsite.dtos;

import java.time.LocalDateTime;

public class PostDto {
    Long id;
    String content;
    String title;
    boolean isVerified;
    LocalDateTime createDateTime;
    LocalDateTime updateDateTime;
    public PostDto(Long id, String content, String title, boolean isVerified, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.isVerified = isVerified;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


}
