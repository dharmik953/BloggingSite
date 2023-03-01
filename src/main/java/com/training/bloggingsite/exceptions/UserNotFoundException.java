package com.training.bloggingsite.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super(String.format("User not found !!"));
    }


}
