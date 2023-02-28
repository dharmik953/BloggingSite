package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.services.interfaces.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JSqlParserUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//comment
@Controller
public class PostController {
    @Autowired
    PostService service;


    Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping("admin/all-post")
    public ModelAndView getAllPost3() {
        List<PostDto> postDto = this.service.getAllPost();

        ModelAndView mav = new ModelAndView("all-post");

        logger.info(postDto.toString() + "added logger");

        mav.addObject("postDto", postDto);
        System.out.println(postDto + "view Mapped");
        return mav;
    }

    @GetMapping("user/all-post")
    public ModelAndView getAllPost() {
        //TobeAdded   with veried post ONly
        // List<PostDto> postDto = service.getAllVerifiedPost();
        List<PostDto> postDto = this.service.getAllPost();

        ModelAndView mav = new ModelAndView("all-post");

     //   logger.info(postDto.toString() + "added logger");

        mav.addObject("postDto", postDto);
        System.out.println(postDto + "view Mapped");
        return mav;

    }

    //TobeAdded for the admin

    @GetMapping("user/post/{postId}")
    public ModelAndView getPostBYPostId(@PathVariable Long postId) {
        ModelAndView mav = new ModelAndView("display-post");
        PostDto postDto = service.getPostById(postId);
        mav.addObject("postid", postDto);
        return mav;
    }


   @GetMapping("user/add-post")
    public ModelAndView addPost(){
   PostDto post=new PostDto();
   ModelAndView modelAndView=new ModelAndView("post-editor");
   modelAndView.addObject("postdto",post);
   return  modelAndView;

    }

//would be called automatically
    @PostMapping("user/save-post")
    public ResponseEntity<PostDto> saveThePost(@ModelAttribute  PostDto post){
        //service.savePost(service.toPostDto(post));

        System.out.println("saved post");
        service.savePost(post);
        //   return ResponseEntity.ok(service.savePost(service.toPostDto(post)));
    return  null;
    }


}
