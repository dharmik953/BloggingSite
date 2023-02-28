package com.training.bloggingsite;

import com.training.bloggingsite.entities.Comment;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.repositories.CommentRepositories;
import com.training.bloggingsite.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BloggingSiteApplicationTests {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepositories commentRepositories;

   // @Test
    void findAllPOstwithPOstTable() {
        Post post=new Post();
        post.setId(1l);
        post.setTitle("buygyuyu");
        post.setContent("uhiuiueiinwo");
        post.setVerified(false);
      //  post.
        postRepository.save(post);
        Post post1 = postRepository.findById(1l).get();
        assertNotNull(post1);

    }

    @Test
    void saveCommentByPost() {
        Post post = new Post();
        Long postId = post.getId();
        Comment comment = new Comment();
        comment.setName("this is comment body");
        comment.setId(12L);
        comment.setCreateDateTime(LocalDateTime.now());
        comment.setVerified(true);
        comment.setUpdateDateTime(LocalDateTime.now());
        comment.setPostId(4L);

        commentRepositories.save(comment);
//        List<Comment> comment1 = commentRepositories.findCommentByPostId();
//        Optional<Comment> comment1 = commentRepositories.findById(comment.getCommentId());
        assertNotNull(comment);
    }

}
