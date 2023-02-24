package com.training.bloggingsite.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryId;

//    @ElementCollection(fetch = FetchType.EAGER)
////    @CollectionTable(name = "subcategory", joinColumns = @JoinColumn(name = "category_id"))
//    private List<SubCategory> subCategory = new ArrayList<>();
////    private Set<String> subCategory = new HashSet<String>();
    private String categoryName;

    @CreationTimestamp
    private LocalDateTime createDateTime;
//    @ElementCollection(fetch = FetchType.EAGER)
////    @CollectionTable(name = "subcategory", joinColumns = @JoinColumn(name = "category_id"))
//    private List<SubCategory> subCategory = new ArrayList<>();
//    private Set<String> subCategory = new HashSet<String>();
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    
     @ManyToOne
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> subCategories = new HashSet<>();

}
