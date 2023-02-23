package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.exceptions.UserAlreadyExistsException;
import com.training.bloggingsite.repositories.UserRepo;
import com.training.bloggingsite.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // Inject the UserRepo class object.
    @Autowired
    UserRepo userRepo;

    // Inject the ModelMapper class object
    @Autowired
    ModelMapper modelMapper;

    @Override
    public User addUser(UserDto userDto) {
        User userToBeInserted = modelMapper.map(userDto, User.class);
        User findUserByEmail = this.userRepo.findByEmail(userToBeInserted.getEmail());
        if(findUserByEmail!=null){
            throw new UserAlreadyExistsException(userToBeInserted.getEmail());
        }
        return this.userRepo.save(userToBeInserted);
    }
}
