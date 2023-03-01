package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.PostRepository;
import com.training.bloggingsite.services.interfaces.PostService;
import com.training.bloggingsite.utils.UserConvertor;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    Logger logger = LoggerFactory.getLogger(PostImpl.class);

    @Override
    public String savePost( PostDto post,UserDto userDto) {
        User user = UserConvertor.toUser(userDto);
        Post postToBeInserted = toPost(post);
        postToBeInserted.setUser(user);
        List<Role> roles = user.getRoles().stream().toList();
        if(roles.get(0).getName().equals("ADMIN")){
            postToBeInserted.setVerified(true);//why
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
        List<Post> postByUserId = postRepository.findPostByUser(user);
        for (Post post : postByUserId)
            postDtos.add(toPostDto(post));

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
        this.postRepository.updateVerificationStatus(postId,!isVerified);
        logger.info("Post verified as : " + !isVerified + " for id "+post.getId());
    }


}
