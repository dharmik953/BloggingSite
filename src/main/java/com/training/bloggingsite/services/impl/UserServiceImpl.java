package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.exceptions.UserEmailAlreadyExistsException;
import com.training.bloggingsite.repositories.RoleRepository;
import com.training.bloggingsite.repositories.UserRepository;
import com.training.bloggingsite.services.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = this.userRepository.findByEmail(userDto.getEmail());
        if(user==null){
            User userToBeInserted = toUser(userDto);
            Role role = this.roleRepository.findByName("USER");
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role);
            userToBeInserted.setRoles(roleSet);
            this.userRepository.save(userToBeInserted);
            logger.info("User Added :" + userDto);
            return userDto;
        }
        else {
            logger.info("User already present with the email "+userDto);
            throw new UserEmailAlreadyExistsException(userDto.getEmail());
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users){
            userDtos.add(toUserDto(user));
        }
        logger.info("Users fetched : "+userDtos);
        return userDtos;
    }

    @Override
    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
        logger.info("User Deleted with id :"+id);
    }

    @Override
    public UserDto getUserById(long id) {
        User user = this.userRepository.findById(id).get();
        UserDto userDto =  toUserDto(user);
        logger.info("User fetched by id :"+userDto+userDto.getId());
        return userDto;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        UserDto userDto =  toUserDto(user);
        logger.info("User fetched by email :"+userDto);
        return userDto;
    }

}
