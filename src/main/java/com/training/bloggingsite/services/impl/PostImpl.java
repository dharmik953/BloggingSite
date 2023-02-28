package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.PostRepository;
import com.training.bloggingsite.services.interfaces.PostService;
import com.training.bloggingsite.services.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    Logger logger = LoggerFactory.getLogger(PostImpl.class);

    @Override
    public String savePost( PostDto post,UserDto userDto) {
        User user = UserService.toUser(userDto);
        Post postToBeInserted = toPost(post);
        postToBeInserted.setUser(user);
        List<Role> roles = user.getRoles().stream().toList();
        if(roles.get(0).getName().equals("ADMIN")){
            postToBeInserted.setVerified(true);
            this.postRepository.save(postToBeInserted);
            logger.info("Post created as : " + postToBeInserted + "by "+userDto.getName());
            return "redirect:/admin/home";
        }
        else {
            postToBeInserted.setVerified(false);
            this.postRepository.save(postToBeInserted);
            logger.info("Post created as : " + postToBeInserted + "by "+userDto.getName());
            return "redirect:/user/home";
        }
    }

    @Override
    public List<PostDto> getAllPost() {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> Allpost = postRepository.findAll();
        for (Post post : Allpost) {
            postDtos.add(toPostDto(post));
        }
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByCategory(Category category) {
        return null;
    }



    @Override
    public PostDto getPostById(Long id) {
        return toPostDto(postRepository.getReferenceById(id));
    }

    @Override
    public List<PostDto> getAllVerifiedPost() {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> Allpost = postRepository.findPostsByIsVerifiedTrue();
        for (Post post : Allpost) {
            postDtos.add(toPostDto(post));
        }
        return postDtos;
    }

    @Override
    public List<PostDto> getAllPostByUser(User user) {
        List<PostDto> postDtos = new ArrayList<>();
        List<Post> id = postRepository.findById(user.getId()).stream().toList();
        for (Post p : id)
            postDtos.add(toPostDto(p));

        return postDtos;
    }

    @Override
    public void deletePost(long id) {
        this.postRepository.deleteById(id);
        logger.info("Post Deleted with id  : " + id);

    }

    @Override
    public void updateVerification(long postId, boolean isVerified) {
        Post post = this.postRepository.findById(postId).get();
        post.setVerified(!isVerified);
        this.postRepository.save(post);

        logger.info("Post verified as : " + !isVerified + "for id "+post.getId());

    }


}
