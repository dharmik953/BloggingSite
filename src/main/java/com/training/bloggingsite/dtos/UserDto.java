package com.training.bloggingsite.dtos;

import com.training.bloggingsite.entities.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    private long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

}
