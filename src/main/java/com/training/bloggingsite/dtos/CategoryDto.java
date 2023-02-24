package com.training.bloggingsite.dtos;

import com.training.bloggingsite.entities.Category;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


public class CategoryDto {
    private long categoryId;
    private String categoryName;
    private Category parentCategory;

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", parentCategory=" + parentCategory +
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

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public CategoryDto(long categoryId, String categoryName, Category parentCategory) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentCategory = parentCategory;
    }

    public CategoryDto() {
    }
}
