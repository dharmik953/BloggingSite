package com.training.bloggingsite;

import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryRepository.class)
@AutoConfigureMockMvc
public class BloggingSiteApplicationTests {

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(username = "admin@admin.com",password = "Mind@123",roles = {"ADMIN"})
    public void testAddCategory() throws Exception {

        Category category = new Category();
        category.setId(1);
        category.setName("Parent");
        List<Category> categories = List.of(category);
        when(categoryRepository.findAll()).thenReturn(categories);

        this.mockMvc.perform(get("/admin/view-categories")).andExpect(status().isOk());
    }

}
