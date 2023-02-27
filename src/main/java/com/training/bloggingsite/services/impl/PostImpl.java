package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.PostRepository;
import com.training.bloggingsite.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostImpl implements PostService {
    @Autowired
    PostRepository repository;


    //toBeadded
    //public PostDto savePost( User user,PostDto post) {
    @Override
    public PostDto savePost( PostDto post) {

        Post savePost = toPost(post);
        repository.save(savePost);

        return toPostDto(repository.save(savePost));

    }


    @Override
    public List<PostDto> getAllPost() {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> Allpost = repository.findAll();

        for (Post p : Allpost)
            postDtos.add(toPostDto(p));

        return postDtos;
    }

   /* @Override
    public PostDto getPostByTitle(String title) { return toPostDto(repository.findPostByTitle(title)); }*/

    @Override
    public List<PostDto> getPostByCategory(Category category) {
        return null;
    }

    @Override
    public PostDto getPostById(Long id) {
        return toPostDto(repository.getReferenceById(id));
    }

    @Override
    public List<PostDto> getAllPostByUser(User user) {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> id = repository.findById(user.getId()).stream().toList();
        for (Post p : id)
            postDtos.add(toPostDto(p));

        return postDtos;
    }

  /*  @Override
    public List<PostDto> getAllVerifiedPost() {
        List<PostDto> postDtos=new ArrayList<>();
        List<Post> verifiedList=repository.findByVerifiedIsTrue();
        for(Post p:verifiedList)
            postDtos.add(toPostDto(p));

        return  postDtos;
    }*/


}
