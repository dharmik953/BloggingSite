package com.training.bloggingsite.exceptions;

public class UserAlreadyExistsException extends RuntimeException{


    public UserAlreadyExistsException(String userEmail){
        super(String.format("User present with email %s !!",userEmail));
    }

}
