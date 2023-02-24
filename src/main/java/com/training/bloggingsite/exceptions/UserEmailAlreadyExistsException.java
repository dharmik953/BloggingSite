package com.training.bloggingsite.exceptions;

public class UserEmailAlreadyExistsException extends RuntimeException{
    public UserEmailAlreadyExistsException(String email){
        super(
                String.format("User with email %s is already present.",email)
        );
    }
}
