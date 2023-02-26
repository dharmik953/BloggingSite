package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.exceptions.CategoryAlreadyExistsException;
import com.training.bloggingsite.exceptions.SubCategoryAlreadyExistsException;
import com.training.bloggingsite.repositories.CategoryRepositories;
import com.training.bloggingsite.services.interfaces.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
    public CategoryDto addSubCategory(long parentId,CategoryDto categoryDto) {

        Category check =this.categoryRepositories.findByCategoryName(categoryDto.getCategoryName());

        if(check==null) {
            Category parentCategory = this.categoryRepositories.findById(parentId).get();
            Category subCategory = toCategory(categoryDto);
            subCategory.setParentCategory(parentCategory);
            this.categoryRepositories.save(subCategory);
            return categoryDto;
        }
        else{
            throw new SubCategoryAlreadyExistsException(categoryDto.getCategoryName(),parentId);
        }
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
