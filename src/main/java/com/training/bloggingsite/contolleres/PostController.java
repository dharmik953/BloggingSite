package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.repositories.PostRepository;
import com.training.bloggingsite.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//comment
@Controller
public class PostController {
    @Autowired
    PostRepository service;

    @GetMapping (  value = "addpost")
    public List<Post> getAllPost() {
        Post post=new Post();
        post.setId(1l);
        post.setTitle("abc");
        post.setContent("abcgcy");
        service.save(post);
        System.out.println(service.findAll().toString()+"THIS IS TAG");
        return service.findAll();


    }

}
