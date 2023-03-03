package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto addCategory(CategoryDto category);

    void deleteCategory(long id);

    List<CategoryDto> findAllCategory();

    CategoryDto findCategoryById(long id);

    CategoryDto addSubCategory(long parentId, CategoryDto categoryDto);

    List<CategoryDto> findCategoryByParent(CategoryDto categoryDto);

    List<CategoryDto> findAllCategoryIncludeChildren();

}