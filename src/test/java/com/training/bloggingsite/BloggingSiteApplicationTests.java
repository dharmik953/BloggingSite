package com.training.bloggingsite;

import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.repositories.PostRepository;
import com.training.bloggingsite.services.interfaces.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BloggingSiteApplicationTests {
    @Autowired
    PostRepository postRepository;
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
        org.junit.jupiter.api.Assertions.assertNotNull(post1);

    }

}
