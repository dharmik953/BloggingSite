package com.training.bloggingsite.utils;

import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.entities.Category;

public class CategoryConvertor {

    public static final Category toCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getId(),
                categoryDto.getName()
        );
    }

    public static final CategoryDto toCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName()
              //  toCategoryDto(category.getParentCategory())
        );
    }

}
