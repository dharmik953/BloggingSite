package com.training.bloggingsite.services;

import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.repositories.CategoryRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepositories repositories;
    @Override
    @Transactional
    public boolean addCategory(Category category) {

        if (isNull(repositories.findByCategoryName(category.getCategoryName()))){
            repositories.save(category);
            return true;
        } else {
            // category already exists
            return false;
        }
    }

    @Override
    @Transactional
    public void deleteCategory(long id) {
        repositories.deleteById(id);
    }

    @Override
    @Transactional
    public List<Category> getAllCategory() {
        return repositories.findAll();
    }

    @Override
    @Transactional
    public Category getCategoryById(long id) {
        Optional<Category> category = repositories.findById(id);
        return category.get();
    }

}
