package com.training.bloggingsite.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {
    private long categoryId;

    @NotBlank
    private String categoryName;

    public CategoryDto(){}

    public CategoryDto(long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
