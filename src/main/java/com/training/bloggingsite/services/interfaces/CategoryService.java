package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.entities.Category;

import java.util.List;

public interface CategoryService {
    default Category toCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getCategoryId(),
                categoryDto.getCategoryName()
        );
    }

    default CategoryDto toCategoryDto(Category category){
        return new CategoryDto(
                category.getCategoryId(),
                category.getCategoryName()
        );
    }

    public CategoryDto addCategory(CategoryDto category);

    public void deleteCategory(long id);

    List<CategoryDto> getAllCategory();

    public CategoryDto getCategoryById(long id);

    public CategoryDto addSubCategory(long parentId,CategoryDto categoryDto);

    public List<CategoryDto> getCategoryByParent(CategoryDto categoryDto);
}