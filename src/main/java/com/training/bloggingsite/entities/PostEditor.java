package com.training.bloggingsite.entities;


import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostEditor {

    private long postId=1;

    @Lob
    private String content;

    private boolean isVerified=false;//is verified by Admin?

    private String title;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;


}
