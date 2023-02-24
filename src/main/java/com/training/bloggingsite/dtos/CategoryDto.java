package com.training.bloggingsite.dtos;

import com.training.bloggingsite.entities.Category;

import java.time.LocalDateTime;
import java.util.Set;


public class CategoryDto {
    private long categoryId;
    private String categoryName;
    private Category parentCategory;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;
    private Set<Category> subCategories;

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", parentCategory=" + parentCategory +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                ", subCategories=" + subCategories +
                '}';
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public CategoryDto(long categoryId, String categoryName, Category parentCategory, LocalDateTime createDateTime, LocalDateTime updateDateTime, Set<Category> subCategories) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentCategory = parentCategory;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.subCategories = subCategories;
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

    public CategoryDto() {
    }
}
