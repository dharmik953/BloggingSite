package com.training.bloggingsite.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {
    private long Id;

    @NotBlank
    private String name;

    public CategoryDto(){}

    public CategoryDto(long Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "categoryName='" + name + '\'' +
                '}';
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
