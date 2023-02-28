
package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long > {

    Category findByName(String name);
    List<Category> findCategoriesByParentCategoryId(long id);
    List<Category> findCategoriesByParentCategoryNull();
}
