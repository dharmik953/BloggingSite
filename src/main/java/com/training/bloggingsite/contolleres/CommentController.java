package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.services.interfaces.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
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

}
