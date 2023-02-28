package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;

import java.util.List;

public interface BookmarkService {

   List<PostDto> getAllBookMarkedPost(UserDto userDto);
     PostDto deleteBookMarkedPostByPostID(UserDto userDto);
    void addBookMarkedPost(PostDto postDto,UserDto userDto);


}
