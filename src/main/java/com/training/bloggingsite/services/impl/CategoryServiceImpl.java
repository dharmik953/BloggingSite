package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.exceptions.CategoryAlreadyExistsException;
import com.training.bloggingsite.exceptions.RoleAlreadyExistsException;
import com.training.bloggingsite.repositories.CategoryRepositories;
import com.training.bloggingsite.services.interfaces.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepositories categoryRepositories;

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {

        Category check =this.categoryRepositories.findByCategoryName(categoryDto.getCategoryName());

        if(check==null) {
            Category categoryToBeInserted = toCategory(categoryDto);
            this.categoryRepositories.save(categoryToBeInserted);
            logger.info("Category Added :" + categoryDto);
            return categoryDto;
        }
        else{
            throw new CategoryAlreadyExistsException(categoryDto.getCategoryName());
        }
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepositories.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepositories.findCategoriesByParentCategoryNull();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category category : categories){
            categoryDtos.add(toCategoryDto(category));
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategoryById(long id) {
        Category category = categoryRepositories.findById(id).get();
        return toCategoryDto(category);
    }

    @Override
    public CategoryDto addSubCategory(CategoryDto categoryName) {
        return null;
    }

    @Override
    public List<CategoryDto> getCategoryByParent(CategoryDto categoryDto) {
        List<Category> categories = this.categoryRepositories.findCategoriesByParentCategoryCategoryId(categoryDto.getCategoryId());
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories){
            categoryDtos.add(toCategoryDto(category));
        }
        return categoryDtos;
    }


}
