package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto addCategory(CategoryDto category);

    public void deleteCategory(long id);

    List<CategoryDto> findAllCategory();

    public CategoryDto findCategoryById(long id);

    public CategoryDto addSubCategory(long parentId,CategoryDto categoryDto);

    public List<CategoryDto> findCategoryByParent(CategoryDto categoryDto);
}