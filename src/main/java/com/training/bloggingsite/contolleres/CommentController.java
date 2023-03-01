package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.services.interfaces.CommentService;
import com.training.bloggingsite.services.interfaces.PostService;
import com.training.bloggingsite.services.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    Logger logger = LoggerFactory.getLogger(CommentController.class);

    public void getVerifiedComment(){
        List<CommentDto> verifiedCommentList = this.commentService.getVerifiedComments();
    }
    public void getUnVerifiedComment(){
        List<CommentDto> unVerifiedCommentList = this.commentService.getUnverifiedComments();
    }
    public void getCommentByPost(long postId){
        List<CommentDto> verifiedCommentList = this.commentService.getCommentByPost(postId);
    }
    public void getCommentByUser(long userId){
        List<CommentDto> verifiedCommentList = this.commentService.getCommentByUser(userId);
    }

    @PostMapping("/user/save-comment")
    public String saveComment(@ModelAttribute("CommentDto") CommentDto commentDto,@RequestParam("postId") long postId
            ,@RequestParam("userEmail") String userEmail) {
        this.commentService.addComment(commentDto,postId,userEmail);
        return "redirect:/user/post/"+postId;
    }

}
