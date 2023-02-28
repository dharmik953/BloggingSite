package com.training.bloggingsite.entities;

import jakarta.persistence.*;


@Entity
public class Category extends BaseEntity{

    @ManyToOne()
    private Category parentCategory;

    public Category(long id, String name) {
        super(id,name);
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Category() {
    }

}
