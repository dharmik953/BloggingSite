package com.training.bloggingsite.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    public Role() {
    }

    public Role(int id, String name) {
        super(id,name);
    }
}

