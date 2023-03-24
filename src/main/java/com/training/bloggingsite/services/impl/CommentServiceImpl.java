package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.contolleres.CommentController;
import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.CommentRepository;
import com.training.bloggingsite.repositories.PostRepository;
import com.training.bloggingsite.repositories.UserRepository;
import com.training.bloggingsite.services.interfaces.CommentService;
import com.training.bloggingsite.utils.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CriteriaQueryBuilder cb;

    @Override
    public String addComment(CommentDto commentDto,long postId,String userEmail) {

        List<User> user = cb.getResultWhereColumnEqual("email",userEmail,User.class);

        List<Post> post = cb.getResultWhereColumnEqual("Id",postId,Post.class);

        commentDto.setUserDto(UserConvertor.toUserDto(user.get(0)));
        commentDto.setPostDto(PostConvertor.toPostDto(post.get(0)));
        List<Role> roles = user.get(0).getRoles().stream().toList();
        if(roles.get(0).getName().equals(DefaultValue.ADMIN)){
            commentDto.setVerified(true);

            // Saved Using JPA
            commentRepository.save(CommentConverter.toComment(commentDto));

            logger.info("Commented by "+user.get(0).getName()+" on post "+post.get(0).getTitle());
            return "redirect:/admin/post/"+post.get(0).getId();
        }
        else {
            commentDto.setVerified(false);

            // Saved Using JPA
            commentRepository.save(CommentConverter.toComment(commentDto));

            logger.info("Commented by "+user.get(0).getName()+" on post "+post.get(0).getTitle());
            return "redirect:/user/post/"+post.get(0).getId();
        }
    }

    @Override
    public List<CommentDto> findCommentByPostVerified(Long postId) {

        List<Post> post = cb.getResultWhereColumnEqual("Id",postId,Post.class);
        List<Comment> comments = cb.getResultWhereColumnEqual(Arrays.asList("post","isVerified"),Arrays.asList(post.get(0),true),Comment.class);

        List<CommentDto> commentDtos = comments.stream().map(CommentConverter::toCommentDto).collect(Collectors.toList());
        return commentDtos;
    }

    @Override
    public List<CommentDto> findAllCommentsByPostId(long postId) {
        List<Post> postIdObj = cb.getResultWhereColumnEqual("Id",postId,Post.class);
        List<Comment> comments =cb.getResultWhereColumnEqual("post",postIdObj.get(0),Comment.class);
        List<CommentDto> commentDtos = comments.stream().map(CommentConverter::toCommentDto).sorted(Comparator.comparing(CommentDto::getId)).collect(Collectors.toList());
        return commentDtos;
    }

    @Override
    public void updateVerification(Long commentId, Boolean isVerified) {
        List<Comment> comment = cb.getResultWhereColumnEqual("Id",commentId,Comment.class);
        cb.updateByColumn("isVerified",commentId,Comment.class,!isVerified);
        logger.info("Comment verified as : " + !isVerified + " for id "+comment.get(0).getId());
    }

    @Override
    public String redirectToPost(String email, long postId) {

        List<User> user = cb.getResultWhereColumnEqual("email",email,User.class);

        List<Role> roles = user.get(0).getRoles().stream().toList();
        if(roles.get(0).getName().equals(DefaultValue.ADMIN)){
            return "redirect:/admin/post/"+postId;
        }
        else {
            return "redirect:/user/post/"+postId;
        }
    }


}
