package com.training.bloggingsite.exceptions;


public class RoleAlreadyExistsException extends RuntimeException{

    public RoleAlreadyExistsException(String role){
        super(String.format("%s role already exists",role));
    }

}
