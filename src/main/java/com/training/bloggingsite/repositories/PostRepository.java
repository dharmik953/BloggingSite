package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //PostEditor getPostById(Long id);
//    public List<Post> findByVerifiedIsTrue(boolean verified);

}
