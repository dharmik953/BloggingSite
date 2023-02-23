package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.PostRepository;
import com.training.bloggingsite.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostImpl  {
//    @Autowired
//    PostRepository repository;
//
//    @Override
//    public Post savePost(User user, Post post) {
//        return repository.save(post);
//
//    }
//
//
//    @Override
//    public List<Post> getAllPost() {
//        return repository.findAll();
//    }
//
//    @Override
//    public Post getPostByTitle(String title) {
//        return null;
//    }
//
//    @Override
//    public List<Post> getPostByCategory(Category category) {
//        return null;
//    }
//
//    @Override
//    public Post getPostById(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<Post> getVerifiedPost(Post post) {
//
//        return repository.findByVerifiedIsTrue(post.isVerified());
//    }
//
//    @Override
//    public List<Post> getAllPostByUser(User user) {
//        Optional<Post> id = repository.findById(user.getId());
//
//        return id.stream().toList();
//    }
//

}
