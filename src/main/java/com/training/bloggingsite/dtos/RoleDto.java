package com.training.bloggingsite.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    private String id;
    private String role;

    @Override
    public String toString() {
        return "RoleDto{" +
                "role='" + role + '\'' +
                '}';
    }
}
