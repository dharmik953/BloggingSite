package com.training.bloggingsite;

import com.training.bloggingsite.contolleres.CategoryController;
import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.repositories.CategoryRepository;
import com.training.bloggingsite.repositories.RoleRepository;
import com.training.bloggingsite.repositories.UserRepository;
import com.training.bloggingsite.security.SecurityConfig;
import com.training.bloggingsite.services.interfaces.CategoryService;
import com.training.bloggingsite.utils.CriteriaQueryBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CategoryControllerTest {

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private CategoryService service;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    CriteriaQueryBuilder cb;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin@admin.com",password = "Mind@123",roles = {"ADMIN"})
    public void viewCategoryTest() throws Exception {

        Category category = new Category();
        category.setId(1);
        category.setName("Parent");
        List<Category> categories = List.of(category);
        when(cb.getAll(Category.class)).thenReturn(categories);

        this.mockMvc.perform(get("/admin/view-categories")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin@admin.com",password = "Mind@123",roles = {"ADMIN"})
    public void testDeleteCategoryTest() throws Exception{
        doNothing().when(service).deleteCategory(any());
        this.mockMvc.perform(get("/admin/delete-category").param("id","1")).andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "admin@admin.com",password = "Mind@123",roles = {"ADMIN"})
    public void addSubCategoriesTest() throws Exception{
        when(service.addCategory(any())).thenReturn(new CategoryDto());
        this.mockMvc.perform(get("/admin/add-subcategory").param("id","1")).andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "admin@admin.com",password = "Mind@123",roles = {"ADMIN"})
    public void findCategoryByIdTest() throws Exception{
       when(service.findCategoryById(anyLong())).thenReturn(new CategoryDto());
       this.mockMvc.perform(get("/admin/view-categories").param("id","1")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin@admin.com",password = "Mind@123",roles = {"ADMIN"})
    public void findSubCategoryByIdTest() throws Exception{
       when(service.addSubCategory(anyLong(), any())).thenReturn(new CategoryDto());
       this.mockMvc.perform(get("/admin/add-subcategory").param("id","1").param("categoryDto" ,"none")).andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "admin@admin.com",password = "Mind@123",roles = {"ADMIN"})
    public void findCategoryByParentTest() throws Exception{
       when(service.findCategoryByParent(any())).thenReturn(new ArrayList<CategoryDto>());
       this.mockMvc.perform(get("/admin/view-categories").param("id","1")).andExpect(status().isOk());
    }


}
