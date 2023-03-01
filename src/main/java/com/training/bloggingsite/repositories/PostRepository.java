package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostByTitle(String title);
    List<Post> findPostsByIsVerifiedTrue();
    List<Post> findPostsByIsVerifiedFalse();
    List<Post> findPostByUser(User user);





    @Modifying
    @Query("UPDATE Post p SET p.isVerified=?2 where p.id=?1")
    void updateVerificationStatus(long id,boolean isVerified);
}