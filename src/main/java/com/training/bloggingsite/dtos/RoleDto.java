package com.training.bloggingsite.dtos;

import jakarta.validation.constraints.NotBlank;

public class RoleDto {

    private int id;

    @NotBlank(message = "Role cannot be Blank !!")
    private String name;

    @Override
    public String toString() {
        return "{" +
                "role='" + name + '\'' +
                '}';
    }

    public RoleDto(){}

    public RoleDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
