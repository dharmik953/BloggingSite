package com.training.bloggingsite.dtos;

import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CommentDto {

    private long Id;

    @Size(min = 4,max = 100,message = "Please enter a valid comment.")
    private String content;
    private UserDto userDto;
    private PostDto postDto;
    private boolean isVerified;
    LocalDateTime createDateTime;
    LocalDateTime updateDateTime;

    public CommentDto(){}

    public CommentDto(long id, String content, UserDto userDto, PostDto postDto, boolean isVerified, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        Id = id;
        this.content = content;
        this.userDto = userDto;
        this.postDto = postDto;
        this.isVerified = isVerified;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(PostDto postDto) {
        this.postDto = postDto;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "content='" + content + '\'' +
                ", userDto=" + userDto +
                ", postDto=" + postDto +
                '}';
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}
