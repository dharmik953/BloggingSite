package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("saveCategory")
    @ResponseBody
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PostMapping("addSubCategory")
    public Category addSubCategory(@RequestBody Category category){
        return categoryService.addSubCategory(category);
    }

    @GetMapping( "getAllCategory")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }
}
