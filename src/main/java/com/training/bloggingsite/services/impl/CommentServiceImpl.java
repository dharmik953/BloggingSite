package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.repositories.CommentRepositories;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepositories repositories;
    @Override
    public Comment addComment(Comment comment) {
        return repositories.save(comment);
    }

    @Override
    public void deleteComment(long id) {
        repositories.deleteById(id);
    }

    @Override

    }

    @Override

    }

    @Override
    public List<Comment> getVerifiedComments() {
        return null;
    }

    @Override
    public List<Comment> getUnverifiedComments() {
        return null;
    }
}
