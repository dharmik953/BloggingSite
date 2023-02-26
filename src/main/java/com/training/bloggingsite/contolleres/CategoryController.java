package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.services.interfaces.CategoryService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("admin/add-category")
    public ModelAndView getAddCategory(){
        ModelAndView mav = new ModelAndView("add-category");
        CategoryDto categoryDto = new CategoryDto();
        mav.addObject("categoryData",categoryDto);
        return mav;
    }

    @PostMapping("admin/add-category-save")
    public String postAddCategory(@Valid  @ModelAttribute("categoryData") CategoryDto categoryDto, BindingResult result){
        if(result.hasErrors()){
            logger.error(String.valueOf(result));
            return "redirect:/admin/add-category";
        }
        this.categoryService.addCategory(categoryDto);
        return "redirect:/admin/view-categories";
    }

    @GetMapping("admin/view-categories")
    public ModelAndView viewCategories(){
        ModelAndView mav = new ModelAndView("view-categories");
        List<CategoryDto> categoryDtos = this.categoryService.getAllCategory();
        mav.addObject("categories",categoryDtos);
        return mav;
    }

    @GetMapping("admin/view-subcategories")
    public ModelAndView viewSubCategories(@RequestParam("id") long id){
        ModelAndView mav = new ModelAndView("view-subcategories");
        CategoryDto categoryDto = this.categoryService.getCategoryById(id);
        List<CategoryDto> categoryDtos = this.categoryService.getCategoryByParent(categoryDto);
        mav.addObject("categories",categoryDtos);
        return mav;
    }

    @GetMapping("admin/delete-category")
    public String deleteCategory(@RequestParam("id") long id){
        this.categoryService.deleteCategory(id);
        return "redirect:/admin/view-categories";
    }

    @GetMapping("/admin/add-subcategory")
    public ModelAndView getAddSubCategory(@RequestParam("id") long id){
        ModelAndView mav = new ModelAndView("add-sub-category");
        CategoryDto categoryDto = new CategoryDto();
        mav.addObject("categoryData",categoryDto);
        mav.addObject("parentId",id);
        return mav;
    }

    @PostMapping("/admin/add-subcategory-save")
    public String postAddSubCategory(@Valid @RequestParam("id") long parentId,
                                     @ModelAttribute("categoryData") CategoryDto categoryDto
                                        ,BindingResult result){

        if(result.hasErrors()){
            logger.error(result.toString());
            return "redirect:/admin/view-categories";
        }

        this.categoryService.addSubCategory(parentId,categoryDto);
        return "redirect:/admin/view-categories";
    }



}
