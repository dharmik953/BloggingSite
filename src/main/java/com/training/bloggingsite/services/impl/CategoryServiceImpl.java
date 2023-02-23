package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.repositories.CategoryRepositories;
import com.training.bloggingsite.services.interfaces.CategoryService;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.isNull;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepositories repositories;
    @Override
    @Transactional
    public Category addCategory(Category category) {

        if (isNull(repositories.findByCategoryName(category.getCategoryName()))){
            repositories.save(category);

        }
//        else {
           ////  category already exists
//        }

        return  repositories.save(category);
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

    @ManyToOne
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> subCategories = new HashSet<>();

    public Category addSubCategory(Category categoryName) {
        Category sub = new Category();
        sub.setCategoryName(categoryName.toString());
        this.subCategories.add(sub);
        sub.setParentCategory(parentCategory);
        return sub;
    }
}
