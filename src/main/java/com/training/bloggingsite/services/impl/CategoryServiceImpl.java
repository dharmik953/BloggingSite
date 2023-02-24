package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.repositories.CategoryRepositories;


import static java.util.Objects.isNull;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepositories repositories;

    }

    @Override
    public void deleteCategory(long id) {
        repositories.deleteById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return repositories.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        Optional<Category> category = repositories.findById(id);
        return category.get();
    }


}
