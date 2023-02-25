package com.training.bloggingsite.exceptions;

public class CategoryAlreadyExistsException extends RuntimeException{
    public CategoryAlreadyExistsException(String category){
        super(String.format("%s category already exists",category));
    }
}
