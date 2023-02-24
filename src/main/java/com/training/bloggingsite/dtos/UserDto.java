package com.training.bloggingsite.dtos;

import com.training.bloggingsite.entities.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class UserDto {

    private long id;

    @Size(min = 5, message = "Please enter a Valid Full Name !!")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9_.\\-]+@[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4}$",message = "Please enter a Valid a Email address !!")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\$\\@]).{6,}$",
            message = "Password must have atleast 6 character. " +
            "Include : one Upper-case, one Lower-case, one Number and one Special Character (@ or $).")
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

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
