package com.training.bloggingsite.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class BookMark  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;//post id //TO BE ADDED

    @OneToOne()//one bookmark can have many post
     Post post;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @OneToOne//one Bookmark can have many user
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
