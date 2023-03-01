package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.training.bloggingsite.utils.CategoryConvertor;
import com.training.bloggingsite.utils.UserConvertor;

import java.util.List;

public interface PostService {

    String savePost(PostDto post, String userEmail, String categoryName);

    List<PostDto> getAllPost();

    PostDto getPostById(Long id);

    List<PostDto> getAllVerifiedPost();

    List<PostDto> getAllPostByUser(User user);

    void deletePost(long id);

    void updateVerification(long postId, boolean isVerified);

    Page<Post> findPaginatedPost(int pageNo,int pageSize);

}
