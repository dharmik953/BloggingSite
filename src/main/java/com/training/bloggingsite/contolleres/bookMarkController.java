package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.services.interfaces.BookmarkService;
import com.training.bloggingsite.services.interfaces.PostService;
import com.training.bloggingsite.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class bookMarkController {
    @Autowired
    BookmarkService bookmarkService;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;
    @GetMapping("user/all-bookmarked-post")
        public ModelAndView findAllBookmarkedPostUser(Principal principal){
            ModelAndView modelAndView=new ModelAndView("user-view-all-post");
        UserDto userDto = userService.findUserByEmail(principal.getName());
        List<PostDto> postDataByBookmark=bookmarkService.getAllBookMarkedPost(userDto);
            modelAndView.addObject("postData",postDataByBookmark);
            return modelAndView;
        }

    @GetMapping("admin/all-bookmarked-post")
    public ModelAndView findAllBookmarkedPostAdmin(Principal principal){
        ModelAndView modelAndView=new ModelAndView("admin-view-all-post");
        UserDto userDto = userService.findUserByEmail(principal.getName());
        List<PostDto> postDataByBookmark=bookmarkService.getAllBookMarkedPost(userDto);

        System.out.println("Book mark : "+postDataByBookmark);
        System.out.println("Book mark User : "+userDto);

        modelAndView.addObject("postData",postDataByBookmark);

        return modelAndView;
    }

    @GetMapping("user/post/change-bookmark-status")
    public String changeBookMarkStatus(@RequestParam long postId,
                                       @RequestParam boolean isBookMarked,
    Principal principal){

        UserDto userDto = userService.findUserByEmail(principal.getName());
        if(isBookMarked){
            bookmarkService.deleteBookMarkedPostByPostID(userDto,postService.findPostById(postId));
        }else
            bookmarkService.addBookMarkedPost(postService.findPostById(postId),userDto);

        return "redirect:/user/post/"+postId;
    }





//?postId=2&isBookMarked=false
}
