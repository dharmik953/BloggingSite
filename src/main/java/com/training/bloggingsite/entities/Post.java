package com.training.bloggingsite.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=1l;

    @Lob
//    @Column(name = "content")
    private String content;
private String title;
  //  @Column(name = "isPostVerifiedByAdmin")
    private boolean isVerified;

    @CreationTimestamp
    //@Column(name="Created_At")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    //@Column(name="Updated_On")
    private LocalDateTime updateDateTime;

}
