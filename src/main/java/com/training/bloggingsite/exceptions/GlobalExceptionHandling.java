package com.training.bloggingsite.exceptions;

import com.training.bloggingsite.dtos.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public String userAlreadyExistsExceptionHandler(Model model,UserAlreadyExistsException exception){
        model.addAttribute("userData",new UserDto());
        model.addAttribute("errors",exception.getMessage());
        return "register";
    }

}
