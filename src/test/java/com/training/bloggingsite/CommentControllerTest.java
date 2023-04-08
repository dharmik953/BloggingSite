package com.training.bloggingsite;

import com.training.bloggingsite.contolleres.CategoryController;
import com.training.bloggingsite.contolleres.CommentController;
import com.training.bloggingsite.dtos.*;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.repositories.RoleRepository;
import com.training.bloggingsite.repositories.UserRepository;
import com.training.bloggingsite.services.interfaces.CategoryService;
import com.training.bloggingsite.services.interfaces.CommentService;
import com.training.bloggingsite.utils.CriteriaQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommentController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CommentControllerTest {

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    CriteriaQueryBuilder cb;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService service;

    @MockBean
    CategoryService categoryService;

    @Test
    public void saveCommentTest() throws Exception {

        when(service.addComment(any(),anyLong(),any())).thenReturn("");
        this.mockMvc.perform(post("/user/save-comment").param("postId","1").param("userEmail","admin@admin.com")).andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "admin@admin.com",password = "Mind@123",roles = {"ADMIN"})
    public void updateCommentTest() throws Exception {
        doNothing().when(service).updateVerification(any(),any());
        this.mockMvc.perform(get("/admin/comment/verification").param("postId","1").param("commentId","1").param("isVerified","true")).andExpect(status().is3xxRedirection());
    }

}
