package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.PostEditor;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.PostRepository;

import java.util.List;

public interface PostService {

    Post savePost(User user, Post post);//save or update post
//    PostEditor updatePost();


    //TOBEAdded
    //Category addCategory(Category category,);//add category thorough DTO

   // String addPostTitle();//update or add title i

    List<Post> getAllPost();

    Post getPostByTitle(String title);

    List<Post> getPostByCategory(Category category);

    Post getPostById(Long id);


    List<Post> getAllPostByUser(User user);
}
