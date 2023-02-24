package com.training.bloggingsite.dtos;

import com.training.bloggingsite.entities.Category;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private long categoryId;
    private String categoryName;
    private Category parentCategory;

}
