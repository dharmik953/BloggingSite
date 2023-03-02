package com.training.bloggingsite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
              @JoinColumn(name = "role_id")
            }
    )
    private Set<Role> roles = new HashSet<>();

    public User(){}

    public User(long id, String name, String email, String encryptedPassword, Set<Role> roles, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        super(id,name,createDateTime,updateDateTime);
        this.email=email;
        this.password=encryptedPassword;
        this.roles=roles;
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
