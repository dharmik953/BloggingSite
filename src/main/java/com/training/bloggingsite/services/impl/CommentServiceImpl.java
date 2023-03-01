package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.contolleres.CommentController;
import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.CommentRepository;
import com.training.bloggingsite.repositories.PostRepository;
import com.training.bloggingsite.repositories.UserRepository;
import com.training.bloggingsite.services.interfaces.CommentService;
import com.training.bloggingsite.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    List<CommentDto> verifiedComment = new ArrayList<>();
    List<CommentDto> unVerifiedComment = new ArrayList<>();

    @Override
    public void addComment(CommentDto commentDto,long postId,String userEmail) {
        User user = this.userRepository.findByEmail(userEmail);
        Post post = this.postRepository.findById(postId).get();
        commentDto.setUserDto(UserConvertor.toUserDto(user));
        commentDto.setPostDto(PostConvertor.toPostDto(post));
        List<Role> roles = user.getRoles().stream().toList();
        if(roles.get(0).getName().equals(DefaultValue.ADMIN)){
            commentDto.setVerified(true);
        }
        else {
            commentDto.setVerified(false);
        }
        commentRepository.save(CommentConverter.toComment(commentDto));
        logger.info("Commented by "+user.getName()+" on post "+post.getTitle());
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentDto> getCommentByUser(long userId) {
        List<Comment> list = new ArrayList<>();
//        return toCommentDto(list.add((Comment) repositories.findByUserId(userId)));
        return null;
    }

    @Override
    public List<CommentDto> getCommentByPost(long postId) {
        return null;
    }

    @Override
    public List<CommentDto> getVerifiedComments() {
        return null;
    }

    @Override
    public List<CommentDto> getUnverifiedComments() {
        return null;
    }

}
