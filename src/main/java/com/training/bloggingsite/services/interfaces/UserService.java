package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.UserDto;
import java.util.List;

public interface UserService {

    public UserDto addUser(UserDto userDto);

    public List<UserDto> findAllUsers();

    public void deleteUser(long id);

    public UserDto findUserById(long id);

    public UserDto findUserByEmail(String email);

    public void updateUserRole(long id,String role);

}
