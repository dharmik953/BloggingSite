package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.User;

import java.util.List;

public interface UserService {

    default UserDto toDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRoles()
                ,user.getCreateDateTime(),user.getUpdateDateTime());
    }

    public UserDto addUser(UserDto userDto);

    public List<UserDto> getAllUsers();

    public void deleteUser(long id);

    public UserDto getUserById(long id);

    public UserDto getUserByEmail(String email);
}
