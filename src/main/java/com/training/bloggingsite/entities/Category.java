package com.training.bloggingsite.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


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

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @ManyToOne
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> subCategories = new HashSet<>();



    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public Category(long categoryId, String categoryName, LocalDateTime createDateTime, LocalDateTime updateDateTime, Category parentCategory, Set<Category> subCategories) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.parentCategory = parentCategory;
        this.subCategories = subCategories;
    }

    public Category() {
    }

    //    @ElementCollection(fetch = FetchType.EAGER)
////    @CollectionTable(name = "subcategory", joinColumns = @JoinColumn(name = "category_id"))
//    private List<SubCategory> subCategory = new ArrayList<>();
//    private Set<String> subCategory = new HashSet<String>();
}
