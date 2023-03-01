package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.contolleres.CommentController;
import com.training.bloggingsite.dtos.CommentDto;
import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.repositories.CommentRepository;
import com.training.bloggingsite.services.interfaces.CommentService;
import com.training.bloggingsite.utils.CategoryConvertor;
import com.training.bloggingsite.utils.CommentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    List<CommentDto> verifiedComment = new ArrayList<>();
    List<CommentDto> unVerifiedComment = new ArrayList<>();

    @Override
    public void addComment(CommentDto comment) {
        commentRepository.save(CommentConverter.toComment(comment));
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
