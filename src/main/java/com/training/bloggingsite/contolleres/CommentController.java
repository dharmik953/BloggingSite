package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.services.interfaces.CommentService;
import com.training.bloggingsite.services.interfaces.PostService;
import com.training.bloggingsite.services.interfaces.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    Logger logger = LoggerFactory.getLogger(CommentController.class);

    // Saving comment.
    @PostMapping("/user/save-comment")
    public String saveComment(@Valid @ModelAttribute("CommentDto") CommentDto commentDto, @RequestParam("postId") long postId
            , @RequestParam("userEmail") String userEmail, BindingResult result) {
        if (result.hasErrors()){
            logger.error(result.toString());
            return "redirect:/user/post/"+postId;
        }
        return  this.commentService.addComment(commentDto,postId,userEmail);
    }

    // Changing the verified status of the comment.
    @GetMapping("/admin/comment/verification")
    public String updateVerification(@RequestParam("postId") long postId,@RequestParam("commentId") long commentId, @RequestParam("isVerified") boolean isVerified) {
        this.commentService.updateVerification(commentId, isVerified);
        return "redirect:/admin/post/"+postId;
    }

}
