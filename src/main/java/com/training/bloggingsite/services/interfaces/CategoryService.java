package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.entities.Category;

import java.util.List;

public interface CategoryService {

    public boolean addCategory(Category category);

    public void deleteCategory(long id);

    List<Category> getAllCategory();

    public Category getCategoryById(long id);

}