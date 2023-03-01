package com.training.bloggingsite.exceptions;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException(){
        super(String.format("No role found !!"));
    }

}
