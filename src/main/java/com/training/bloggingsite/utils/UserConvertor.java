package com.training.bloggingsite.utils;

import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserConvertor {


    public static final UserDto toUserDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRoles()
                ,user.getCreateDateTime(),user.getUpdateDateTime());
    }

    public static final User toUser(UserDto userDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encrptedPassword = encoder.encode(userDto.getPassword());
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail(),encrptedPassword , userDto.getRoles()
                ,userDto.getCreateDateTime(),userDto.getUpdateDateTime());
    }

}
