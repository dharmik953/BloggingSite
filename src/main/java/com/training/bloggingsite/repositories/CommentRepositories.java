package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepositories extends JpaRepository<Comment,Long > {
}
