package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.User;

import java.util.List;

public interface PostService {

    PostDto savePost(User user, PostDto post);//save or update post
//    PostEditor updatePost();


    //TOBEAdded
    //Category addCategory(Category category,);//add category thorough DTO

   // String addPostTitle();//update or add title i

    List<PostDto> getAllPost();

    PostDto getPostByTitle(String title);

    List<PostDto> getPostByCategory(Category category);

    PostDto getPostById(Long id);


    List<PostDto> getAllPostByUser(User user);



    default PostDto toPostDto(Post post){
        return new PostDto(
          post.getId(),
          post.getContent()  ,
          post.getTitle(),
          post.isVerified(),
          post.getCreateDateTime(),
          post.getUpdateDateTime()
        );
    }

    default Post toPost(PostDto postDto){
        return new Post(
                postDto.getId(),
                postDto.getContent(),
                postDto.getTitle(),
                postDto.isVerified(),
                postDto.getCreateDateTime(),
                postDto.getUpdateDateTime()
        );
    }
}
