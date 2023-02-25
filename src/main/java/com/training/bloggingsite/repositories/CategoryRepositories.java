
package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepositories extends JpaRepository<Category,Long > {
    Category findByCategoryName(String name);
    List<Category> findCategoriesByParentCategoryCategoryId(long id);
    List<Category> findCategoriesByParentCategoryNull();
}
