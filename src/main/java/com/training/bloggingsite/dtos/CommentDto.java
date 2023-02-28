package com.training.bloggingsite.dtos;

import java.time.LocalDateTime;

public class CommentDto {

    private long IdDto;

    private boolean isVerifiedCommentDto = false;

    private LocalDateTime createDateTimeCommentDto;

    private LocalDateTime updateDateTimeCommentDto;
    private String nameDto;

    @Override
    public String toString() {
        return "CommentDto{" +
                "commentIdDto=" + IdDto +
                ", isVerifiedCommentDto=" + isVerifiedCommentDto +
                ", createDateTimeCommentDto=" + createDateTimeCommentDto +
                ", updateDateTimeCommentDto=" + updateDateTimeCommentDto +
                ", commentContentDto='" + nameDto + '\'' +
                '}';
    }

    public long getIdDto() {
        return IdDto;
    }

    public void setIdDto(long idDto) {
        this.IdDto = idDto;
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

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public CommentDto() {
    }

    public CommentDto(long IdDto, boolean isVerifiedCommentDto, LocalDateTime createDateTimeCommentDto, LocalDateTime updateDateTimeCommentDto, String nameDto) {
        this.IdDto = IdDto;
        this.isVerifiedCommentDto = isVerifiedCommentDto;
        this.createDateTimeCommentDto = createDateTimeCommentDto;
        this.updateDateTimeCommentDto = updateDateTimeCommentDto;
        this.nameDto = nameDto;
    }
}
