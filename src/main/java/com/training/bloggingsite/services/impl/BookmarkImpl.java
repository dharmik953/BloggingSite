package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.BookMark;
import com.training.bloggingsite.services.interfaces.BookmarkService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class BookmarkImpl implements BookmarkService {

    @Override
    public List<PostDto> getAllBookMarkedPost(UserDto userDto) {
        return null;
    }

    @Override
    public List<PostDto> deleteBookMarkedPost(UserDto userDto) {
        return null;
    }

    @Override
    public List<PostDto> addBookMarkedPost(UserDto userDto) {
        return null;
    }
}
