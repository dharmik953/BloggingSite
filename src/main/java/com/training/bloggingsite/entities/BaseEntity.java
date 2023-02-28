package com.training.bloggingsite.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public BaseEntity() {
    }

    public BaseEntity(long id, String name, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        Id = id;
        this.name = name;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public BaseEntity(long id, String name) {
        Id = id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", createdTime=" + createDateTime +
                ", updatedTime=" + updateDateTime +
                '}';
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createdTime) {
        this.createDateTime = createdTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updatedTime) {
        this.updateDateTime = updatedTime;
    }
}
