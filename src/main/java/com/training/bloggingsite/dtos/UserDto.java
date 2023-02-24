package com.training.bloggingsite.dtos;

import com.training.bloggingsite.entities.Role;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UserDto {

    private long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public UserDto(){}

    public UserDto(long id, String name, String email, String password, Set<Role> roles,
    LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
