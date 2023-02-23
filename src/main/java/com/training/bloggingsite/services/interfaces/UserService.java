package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.User;

public interface UserService {

    public User addUser(UserDto userDto);


}
