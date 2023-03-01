package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
   List<Comment> findByPostIdAndIsVerifiedTrue(long postId);
   List<Comment> findAllByPostId(long postId);

   @Modifying
   @Query("UPDATE Comment c SET c.isVerified=?2 where c.Id=?1")
   void updateVerificationStatus(long id,boolean isVerified);
}
