package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.entities.User;
import java.util.List;

public interface PostService {

    String savePost(PostDto post, String userEmail, String categoryName);

    PostDto findPostById(long id);

    List<PostDto> findAllPostByUser(User user);

    void deletePost(long id);

    void updateVerification(long postId, boolean isVerified);

     default List<PostDto> findPaginatedVerifiedPost(int pageNo,int pageSize){return null;}

   <T> List<PostDto> findPaginatedPosts(int pageNo,int pageSize,String columnName,T value);

    <T> int findTotalPages(String ColumnName, T value);



}
