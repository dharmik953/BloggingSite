package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.services.interfaces.PostService;
import com.training.bloggingsite.services.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

//comment
@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;


    Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping("admin/delete-post")
    public String delterPost(@RequestParam("id") long id){
        this.postService.deletePost(id);
        return "redirect:/admin/all-post";
    }

    @GetMapping("admin/all-post")
    public ModelAndView getAllPost3() {
        List<PostDto> postDto = this.postService.getAllPost();
        ModelAndView mav = new ModelAndView("admin-view-all-post");
        mav.addObject("postData", postDto);
        return mav;
    }

    @GetMapping("user/all-post")
    public ModelAndView getAllPost() {
        List<PostDto> postDto = this.postService.getAllPost();
        ModelAndView mav = new ModelAndView("/");
        mav.addObject("postData", postDto);
        return mav;
    }

    @GetMapping("user/post/{postId}")
    public ModelAndView getPostBYPostId(@PathVariable Long postId) {
        ModelAndView mav = new ModelAndView("view-post");
        PostDto postDto = postService.getPostById(postId);
        mav.addObject("postid", postDto);
        return mav;
    }

    @GetMapping("user/add-post")
    public ModelAndView addPost() {
        PostDto post = new PostDto();
        ModelAndView modelAndView = new ModelAndView("add-post");
        modelAndView.addObject("postdto", post);
        return modelAndView;
    }

    @PostMapping("user/save-post")
    public String saveThePost(@ModelAttribute PostDto post, Principal principal) {
        UserDto userDto = this.userService.getUserByEmail(principal.getName());
        return this.postService.savePost(post, userDto);
    }

    @GetMapping("/admin/post/verification")
    public String updateVerification(@RequestParam("postId") long postId,@RequestParam  ("isVerified") boolean isVerified){
        this.postService.updateVerification(postId,isVerified);
        return "redirect:/admin/all-post";
    }

}
