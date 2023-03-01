package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.BookMark;
import com.training.bloggingsite.repositories.BookMarkRepository;
import com.training.bloggingsite.services.interfaces.BookmarkService;
import com.training.bloggingsite.services.interfaces.PostService;
import com.training.bloggingsite.services.interfaces.UserService;
import com.training.bloggingsite.utils.PostConvertor;
import com.training.bloggingsite.utils.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookmarkImpl implements BookmarkService {
    @Autowired
    BookMarkRepository bookMarkRepository;

    @Autowired
    PostService postService;
    @Override
    public List<PostDto> getAllBookMarkedPost(UserDto userDto) {

        return null;
    }

    @Override
    public PostDto deleteBookMarkedPostByPostID(UserDto userDto) {

        return null;
    }

    @Override
    public void addBookMarkedPost(PostDto postDto,UserDto userDto) {

        BookMark bookMark=new BookMark();
        bookMark.setUser(UserConvertor.toUser(userDto));
        bookMark.setPost(PostConvertor.toPost(postDto));

        bookMarkRepository.save(bookMark);
//        return null;
    }
}
