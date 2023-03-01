package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

    String savePost(PostDto post, String userEmail, String categoryName);

    List<PostDto> findAllPost();

    PostDto findPostById(long id);

    List<PostDto> findAllVerifiedPost();

    List<PostDto> findAllPostByUser(User user);

    void deletePost(long id);

    void updateVerification(long postId, boolean isVerified);

    Page<Post> findPaginatedPost(int pageNo,int pageSize);

}
