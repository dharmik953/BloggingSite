package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.PostEditor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    //PostEditor getPostById(Long id);
 //   public List<Post> findByVerifiedIsTrue(boolean verified);


}
