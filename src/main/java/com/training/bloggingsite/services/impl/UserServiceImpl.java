package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.exceptions.UserEmailAlreadyExistsException;
import com.training.bloggingsite.exceptions.UserNotFoundException;
import com.training.bloggingsite.repositories.RoleRepository;
import com.training.bloggingsite.repositories.UserRepository;
import com.training.bloggingsite.services.interfaces.UserService;
import com.training.bloggingsite.utils.CriteriaQueryBuilder;
import com.training.bloggingsite.utils.DefaultValue;
import com.training.bloggingsite.utils.UserConvertor;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EntityManager em;

    private CriteriaQueryBuilder<User> cbForUser;
    private CriteriaQueryBuilder<Role> cbForRole ;

    @PostConstruct
    public void init(){
        cbForUser = new CriteriaQueryBuilder<>(User.class,em);
        cbForRole = new CriteriaQueryBuilder<>(Role.class,em);
    }

    private final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public UserDto addUser(UserDto userDto) {
        List<User> user = cbForUser.getResultWhereColumnEqual("email",userDto.getEmail());
        if (user.isEmpty()) {
            User userToBeInserted = UserConvertor.toUser(userDto);
            List<Role> role = cbForRole.getResultWhereColumnEqual("name",DefaultValue.USER);
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role.get(0));
            userToBeInserted.setRoles(roleSet);
//            this.userRepository.save(userToBeInserted);
            em.persist(userToBeInserted); //------------Persistent Save -------------------
            logger.info("User Added :" + userDto);
            return userDto;
        } else {
            logger.info("User already present with the email " + userDto);
            throw new UserEmailAlreadyExistsException(userDto.getEmail());
        }
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = cbForUser.getAll();
        if (users.isEmpty()) {
            throw new UserNotFoundException();
        }
        List<UserDto> userDtos = users.stream().map(U->UserConvertor.toUserDto(U)).collect(Collectors.toList());
        logger.info("Users fetched : " + userDtos);
        return userDtos;
    }

    @Override
    public UserDto findUserById(long id) {
//        User user = this.userRepository.findById(id).get();
        List<User> user = cbForUser.getResultWhereColumnEqual("id",id);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserDto userDto = UserConvertor.toUserDto(user.get(0));
        logger.info("User fetched by id :" + userDto + userDto.getId());
        return userDto;
    }

    @Override
    public UserDto findUserByEmail(String email) {
        List<User> user = cbForUser.getResultWhereColumnEqual("email",email);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserDto userDto = UserConvertor.toUserDto(user.get(0));
        logger.info("User fetched by email :" + userDto);
        return userDto;
    }

    @Override
    public void updateUserRole(long id, String role) {
        List<User> user = cbForUser.getResultWhereColumnEqual("id",id);
        Set<Role> roleSet = new HashSet<>();
        List<Role> roleToInsert = cbForRole.getResultWhereColumnEqual("name",role.equals(DefaultValue.ADMIN) ? DefaultValue.USER : DefaultValue.ADMIN);

        roleSet.add(roleToInsert.get(0));
        user.get(0).setRoles(roleSet);
        logger.info("User " + user.get(0).getName() + " changed as " + roleToInsert.get(0).getName() + ".");
        this.userRepository.save(user.get(0));
//        em.persist(user);//------------Persistent Save -------------------
    }


}
