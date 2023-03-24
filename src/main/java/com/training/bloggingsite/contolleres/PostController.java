package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.CategoryDto;
import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.services.interfaces.*;
import com.training.bloggingsite.utils.UserConvertor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


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

    // Verification of the post, posted by user. (For admin auto verification)
    @GetMapping("/admin/post/verification")
    public String updateVerification(@RequestParam("postId") long postId, @RequestParam("isVerified") boolean isVerified,@RequestParam("pageNo")int pageNo) {
        this.postService.updateVerification(postId, isVerified);
        return "redirect:/admin/all-post?pageNo="+pageNo;
    }

    // Open the Edit post Dialog at admin side.
    @GetMapping("admin/update-mypost")
    public ModelAndView getEditPostAdmin(@RequestParam("id") long postId,Principal principal) {
        PostDto postDto = this.postService.findPostById(postId);
        ModelAndView modelAndView = new ModelAndView("admin-edit-mypost");
        List<CategoryDto> categoryDtos = this.categoryService.findAllCategoryIncludeChildren();
        modelAndView.addObject("postdto", postDto);
        modelAndView.addObject("categories",categoryDtos);
        return modelAndView;
    }

    // Delete Admins own post.
    @GetMapping("admin/delete-mypost")
    public String deleteMyPostAdmin(@RequestParam("id") long id) {
        this.postService.deletePost(id);
        return "redirect:/admin/my-post";
    }

    // View all posts to admin.
    @GetMapping("admin/all-post")
    public ModelAndView getAllPostForAdmin(@RequestParam("pageNo") int pageNo) {
        int pageLimit=5;
        List<PostDto> postList = postService.findPaginatedPost((pageNo > 1) ? (pageNo-1) * pageLimit : pageNo-1, pageLimit);


        ModelAndView modelAndView = new ModelAndView("admin-view-all-post");
        modelAndView.addObject("currentPage", pageNo);
        modelAndView.addObject("totalPages", postService.findTotalPages(pageNo,5));
        modelAndView.addObject("postData", postList);
        return modelAndView;
    }

    // View  individual post at admin side.
    @GetMapping("admin/my-post")
    public ModelAndView getAdminPost(Principal principal) {
        UserDto userDto = userService.findUserByEmail(principal.getName());
        List<PostDto> postDto = postService.findAllPostByUser(UserConvertor.toUser(userDto));
        ModelAndView modelAndView = new ModelAndView("admin-view-all-my-post");
        modelAndView.addObject("postData", postDto);
        return modelAndView;
    }

    // Displaying specific Post to admin.
    @GetMapping("admin/post/{postId}")
    public ModelAndView getPostByPostIdAdmin(@PathVariable long postId, Principal principal) {
        ModelAndView mav = new ModelAndView("view-post-admin");
        List<CommentDto> commentDtos = this.commentService.findAllPostById(postId);
        PostDto postDto = postService.findPostById(postId);
        UserDto userDto = userService.findUserByEmail(principal.getName());
        boolean isBookMarked = this.bookmarkService.isBookMarked(userDto, postId);
        mav.addObject("userEmail", principal.getName());
        mav.addObject("commentDto", new CommentDto());
        mav.addObject("postDto", postDto);
        mav.addObject("commentList", commentDtos);
        mav.addObject("isBookMarked", isBookMarked);
        return mav;
    }

    // Delete Users own post.
    @GetMapping("user/delete-mypost")
    public String deleteMyPostUser(@RequestParam("id") long id) {
        this.postService.deletePost(id);
        return "redirect:/user/my-post";
    }

    // View all posts to user.
    @GetMapping("user/all-post")
    public ModelAndView getAllPostForUser(@RequestParam("pageNo") int pageNo) {
        int pageLimit=5;
        List<PostDto> postList = postService.findPaginatedPost((pageNo > 1) ? (pageNo - 1) * pageLimit : pageNo - 1, pageLimit);

        ModelAndView modelAndView = new ModelAndView("user-view-all-post");

        modelAndView.addObject("currentPage", pageNo);
        modelAndView.addObject("totalPages", postService.findTotalPages(pageNo,5));
        modelAndView.addObject("postData", postList);
        return modelAndView;
    }

    // Displaying specific Post to user.
    @GetMapping("user/post/{postId}")
    public ModelAndView getPostByPostIdUser(@PathVariable long postId,Principal principal) {
        ModelAndView mav = new ModelAndView("view-post-user");
        logger.info("inside postid");

        List<CommentDto> commentDtos = this.commentService.findCommentByPostVerified(postId);
        logger.info("after postid commentDtos");
        List<CommentDto> commentDtos = this.commentService.findCommentByPostVerified(postId);
        PostDto postDto = postService.findPostById(postId);
        UserDto userDto = userService.findUserByEmail(principal.getName());
        boolean isBookMarked = this.bookmarkService.isBookMarked(userDto,postId);
        mav.addObject("userEmail",principal.getName());
        mav.addObject("commentDto",new CommentDto());
        mav.addObject("postDto", postDto);
        mav.addObject("commentList", commentDtos);
        mav.addObject("isBookMarked", isBookMarked);
        return mav;
    }

    // Open the Edit post Dialog at user side.
    @GetMapping("user/update-mypost")
    public ModelAndView getEditPostUser(@RequestParam("id") long postId,Principal principal) {
        System.out.println("entered in mthpd");
        PostDto postDto = this.postService.findPostById(postId);
        ModelAndView modelAndView = new ModelAndView("user-edit-mypost");
        List<CategoryDto> categoryDtos = this.categoryService.findAllCategoryIncludeChildren();
        modelAndView.addObject("categories",categoryDtos);
        modelAndView.addObject("postdto", postDto);
        return modelAndView;
    }

    // Add new Post
    @GetMapping("user/add-post")
    public ModelAndView addPost() {
        PostDto postDto = new PostDto();
        ModelAndView modelAndView = new ModelAndView("add-post");
        List<CategoryDto> categoryDtos = this.categoryService.findAllCategoryIncludeChildren();
        modelAndView.addObject("categories",categoryDtos);
        modelAndView.addObject("postdto", postDto);
        return modelAndView;
    }

    // Save New post.
    @PostMapping("user/save-post")
    public String saveThePost(@ModelAttribute PostDto post, Principal principal) {
        return this.postService.savePost(post, principal.getName(),post.getCategoryDto().getName());
    }

    // View  individual post at user side.
    @GetMapping("user/my-post")
    public ModelAndView getUserPost(Principal principal) {
        UserDto userDto = userService.findUserByEmail(principal.getName());
        List<PostDto> postDto = postService.findAllPostByUser(UserConvertor.toUser(userDto));
        ModelAndView modelAndView = new ModelAndView("user-view-all-my-post");
        modelAndView.addObject("postData", postDto);
        return modelAndView;
    }




}
