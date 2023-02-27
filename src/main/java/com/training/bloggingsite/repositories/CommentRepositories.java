package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepositories extends JpaRepository<Comment,Long > {
    List<Comment> findByPostId(long postId);
    List<Comment> findByUserId(long userId);
}
