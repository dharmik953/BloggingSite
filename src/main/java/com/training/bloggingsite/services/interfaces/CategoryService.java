package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.entities.Category;

import java.util.List;

public interface CategoryService {
    default Category toCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getCategoryId(),
                categoryDto.getCategoryName(),
                categoryDto.getUpdateDateTime(),
                categoryDto.getCreateDateTime(),
                categoryDto.getParentCategory(),
                categoryDto.getSubCategories()
        );
    }

    default CategoryDto toCategoryDto(Category category){
        return new CategoryDto(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getParentCategory(),
                category.getCreateDateTime(),
                category.getUpdateDateTime(),
                category.getSubCategories());
    }

    public Category addCategory(Category category);

    public void deleteCategory(long id);

    List<Category> getAllCategory();

    public Category getCategoryById(long id);

    public Category addSubCategory(Category categoryName);
}