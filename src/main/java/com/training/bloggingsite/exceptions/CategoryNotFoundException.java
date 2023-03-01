package com.training.bloggingsite.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(){
        super(String.format("Category Not Found !!"));
    }
}
