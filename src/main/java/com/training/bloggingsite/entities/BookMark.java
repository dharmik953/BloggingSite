package com.training.bloggingsite.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Set;

@Entity
public class BookMark  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;

    @OneToOne()
     Post post;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @OneToOne
    User user;

    public BookMark() {
    }

    public BookMark(Long id, Set<Post> postSet) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
