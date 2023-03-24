package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.exceptions.CategoryAlreadyExistsException;
import com.training.bloggingsite.exceptions.CategoryNotFoundException;
import com.training.bloggingsite.exceptions.SubCategoryAlreadyExistsException;
import com.training.bloggingsite.repositories.CategoryRepository;
import com.training.bloggingsite.services.interfaces.CategoryService;
import com.training.bloggingsite.utils.CategoryConvertor;
import com.training.bloggingsite.utils.CriteriaQueryBuilder;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepositories;

    @Autowired
    CriteriaQueryBuilder cb;

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {

        List<Category> categories = this.cb.getResultWhereColumnEqual("name", categoryDto.getName(),Category.class);
//        Category checkCategoryInDB =this.categoryRepositories.findByName(categoryDto.getName());

        if (categories.isEmpty()) {
            Category categoryToBeInserted = CategoryConvertor.toCategory(categoryDto);
//            categoryToBeInserted.getParentCategory().setp(0);
            // saved using JPA
            this.categoryRepositories.save(categoryToBeInserted);

            logger.info("Category Added :" + categoryDto);
            return categoryDto;
        } else {
            throw new CategoryAlreadyExistsException(categoryDto.getName());
        }
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepositories.deleteById(id);
        logger.info("Category deleted by  :" + id);
    }

    @Override
    public List<CategoryDto> findAllCategory() {
        List<Category> categories = cb.getResultWhereColumnIsNull("parentCategory",Category.class);
//        List<Category> categories = this.categoryRepositories.findCategoriesByParentCategoryNull();
        if (categories == null) {
            throw new CategoryNotFoundException();
        }
        List<CategoryDto> categoryDtos = categories.stream().map(CategoryConvertor::toCategoryDto).collect(Collectors.toList());
        logger.info("Category fetched :" + categoryDtos);
        return categoryDtos;
    }

    @Override
    public CategoryDto findCategoryById(long id) {
        Category category = categoryRepositories.findById(id).get();
        if (category == null) {
            throw new CategoryNotFoundException();
        }
        CategoryDto categoryDto = CategoryConvertor.toCategoryDto(category);
        logger.info("Category fetched by Id:" + categoryDto);
        return categoryDto;
    }

    @Override
    public CategoryDto addSubCategory(long parentId, CategoryDto categoryDto) {

        List<Category> checkSubCategoryInDB = cb.getResultWhereColumnEqual("name", categoryDto.getName(),Category.class);

        if (checkSubCategoryInDB.isEmpty()) {
            Category parentCategory = this.categoryRepositories.findById(parentId).get();
            Category subCategory = CategoryConvertor.toCategory(categoryDto);
            subCategory.setParentCategory(parentCategory);
            subCategory.setId(0);
            this.categoryRepositories.save(subCategory);
            logger.info("Sub Category Added:" + subCategory);
            return categoryDto;
        } else {
            throw new SubCategoryAlreadyExistsException(categoryDto.getName(), parentId);
        }
    }

    @Override
    public List<CategoryDto> findCategoryByParent(CategoryDto categoryDto) {
        Category category = CategoryConvertor.toCategory(categoryDto);
        List<Category> categories = cb.getResultWhereColumnEqual("parentCategory", category,Category.class);
        List<CategoryDto> categoryDtos = categories.stream().map(C -> CategoryConvertor.toCategoryDto(C)).collect(Collectors.toList());
        logger.info("Category fetched as parent :" + categoryDtos);
        return categoryDtos;
    }

    @Override
    public List<CategoryDto> findAllCategoryIncludeChildren() {
        List<Category> categories = this.categoryRepositories.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(C -> CategoryConvertor.toCategoryDto(C)).collect(Collectors.toList());
        logger.info("Category fetched as all :" + categoryDtos);
        return categoryDtos;
    }


}
