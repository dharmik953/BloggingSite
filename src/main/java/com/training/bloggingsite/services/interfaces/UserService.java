package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public interface UserService {

    default UserDto toUserDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRoles()
                ,user.getCreateDateTime(),user.getUpdateDateTime());
    }

    default User toUser(UserDto userDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encrptedPassword = encoder.encode(userDto.getPassword());
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail(),encrptedPassword , userDto.getRoles()
                ,userDto.getCreateDateTime(),userDto.getUpdateDateTime());
    }

    public UserDto addUser(UserDto userDto);

    public List<UserDto> getAllUsers();

    public void deleteUser(long id);

    public UserDto getUserById(long id);

    public UserDto getUserByEmail(String email);

}
