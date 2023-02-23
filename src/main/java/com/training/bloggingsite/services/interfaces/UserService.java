package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.dtos.UserDto;

import java.util.List;

public interface UserService {

    public UserDto addUser(UserDto userDto);

    public List<UserDto> getAllUsers();

    public void deleteUser(int id);

    public UserDto getUserById(int id);




}
