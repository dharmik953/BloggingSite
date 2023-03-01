package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.services.interfaces.*;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.utils.UserConvertor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    BookmarkService bookmarkService;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CommentService commentService;

    Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping("admin/delete-mypost")
    public String deleteMyPostAdmin(@RequestParam("id") long id) {
        this.postService.deletePost(id);
        return "redirect:/admin/my-post";
    }

    @GetMapping("user/delete-mypost")
    public String deleteMyPostUser(@RequestParam("id") long id) {
        this.postService.deletePost(id);
        return "redirect:/user/my-post";
    }

    @GetMapping("admin/all-post")
    public ModelAndView getAllPostForAdmin() {
        List<PostDto> postDto = this.postService.findAllPost();
        ModelAndView mav = new ModelAndView("admin-view-all-post");
        mav.addObject("postData", postDto);
        return mav;
    }

    @GetMapping("user/all-post")
    public ModelAndView getAllPostForUser() {
        List<PostDto> postDto = postService.findAllVerifiedPost();
        ModelAndView mav = new ModelAndView("user-view-all-post");
        mav.addObject("postData", postDto);
        return mav;
    }

    @GetMapping("user/post/{postId}")
    public ModelAndView getPostByPostIdUser(@PathVariable long postId,Principal principal) {
        ModelAndView mav = new ModelAndView("view-post-user");
        PostDto postDto = this.postService.findPostById(postId);
        List<CommentDto> commentDtos = this.commentService.findCommentByPostVerified(postId);
        System.out.println("Comments :"+commentDtos);
        mav.addObject("userEmail",principal.getName());
        mav.addObject("commentDto",new CommentDto());
        mav.addObject("postDto", postDto);
        mav.addObject("postid", postDto);
        mav.addObject("commentList", commentDtos);
        UserDto userDto = userService.findUserByEmail(principal.getName());
        boolean isBookMarked = false;
        List<PostDto> bookMarkedPostsList = bookmarkService.getAllBookMarkedPost(userDto);
        for (PostDto bookmarkpost : bookMarkedPostsList) {
            if (bookmarkpost.getId() == postId) {
                isBookMarked = true;
                break;
            }
        }
        mav.addObject("isBookMarked", isBookMarked);
        return mav;
    }

    @GetMapping("admin/post/{postId}")
    public ModelAndView getPostByPostIdAdmin(@PathVariable long postId,Principal principal) {
        ModelAndView mav = new ModelAndView("view-post-admin");
        List<CommentDto> commentDtos = this.commentService.findAllPostById(postId);
        PostDto postDto = postService.findPostById(postId);
        mav.addObject("userEmail",principal.getName());
        mav.addObject("commentDto",new CommentDto());
        mav.addObject("postDto", postDto);
        mav.addObject("postid", postDto);
        mav.addObject("commentList", commentDtos);
        UserDto userDto = userService.findUserByEmail(principal.getName());
        boolean isBookMarked = false;
        List<PostDto> bookMarkedPostsList = bookmarkService.getAllBookMarkedPost(userDto);
        for (PostDto bookmarkpost : bookMarkedPostsList) {
            if (bookmarkpost.getId() == postId) {
                isBookMarked = true;
                break;
            }
        }
        mav.addObject("isBookMarked", isBookMarked);
        return mav;
    }

    @GetMapping("user/add-post")
    public ModelAndView addPost() {
        PostDto postDto = new PostDto();
        CategoryDto categoryDto = new CategoryDto();
        ModelAndView modelAndView = new ModelAndView("add-post");
        modelAndView.addObject("postdto", postDto);
        List<CategoryDto> categoryDtos = this.categoryService.findAllCategoryIncludeChildren();
        modelAndView.addObject("categories",categoryDtos);
        return modelAndView;
    }

    @PostMapping("user/save-post")
    public String saveThePost(@ModelAttribute PostDto post, Principal principal) {
        return this.postService.savePost(post, principal.getName(),post.getCategoryDto().getName());
    }

    @GetMapping("/admin/post/verification")
    public String updateVerification(@RequestParam("postId") long postId, @RequestParam("isVerified") boolean isVerified) {
        this.postService.updateVerification(postId, isVerified);
        return "redirect:/admin/all-post";
    }

    @GetMapping("user/my-post")
    public ModelAndView getUserPost(Principal principal) {
        UserDto userDto = userService.findUserByEmail(principal.getName());
        List<PostDto> postDto = postService.findAllPostByUser(UserConvertor.toUser(userDto));
        ModelAndView modelAndView = new ModelAndView("user-view-all-my-post");
        modelAndView.addObject("postData", postDto);
        return modelAndView;
    }

    @GetMapping("admin/my-post")
    public ModelAndView getAdminPost(Principal principal) {
        UserDto userDto = userService.findUserByEmail(principal.getName());
        List<PostDto> postDto = postService.findAllPostByUser(UserConvertor.toUser(userDto));
        ModelAndView modelAndView = new ModelAndView("admin-view-all-my-post");
        modelAndView.addObject("postData", postDto);
        return modelAndView;
    }


    @GetMapping("user/all-post/a")
    public ModelAndView displayPaginatedPosts(@RequestParam("pageNo") int pageNo) {
        Page<Post> paginatedPostList = postService.findPaginatedPost(pageNo, 10);
        Page<Post> postList = postService.findPaginatedPost(pageNo, 10);
        ModelAndView modelAndView = new ModelAndView("user-view-all-post");
        modelAndView.addObject("currentPage", pageNo);
        modelAndView.addObject("totalPages", paginatedPostList.getTotalPages());
        modelAndView.addObject("totalItems", paginatedPostList.getTotalElements());
        modelAndView.addObject("currentPage", postList);
        return modelAndView;

    }

}
