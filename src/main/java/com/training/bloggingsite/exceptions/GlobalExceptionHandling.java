package com.training.bloggingsite.exceptions;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.dtos.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(value = RoleAlreadyExistsException.class)
    public String roleAlreadyExistsExceptionHandler(Model model, RoleAlreadyExistsException e){
        model.addAttribute("error",e.getMessage());
        model.addAttribute("roleData",new RoleDto());
        return "add-role";
    }

    @ExceptionHandler(value = UserEmailAlreadyExistsException.class)
    public String userEmailAlreadyExistsExceptionHandler(Model model,UserEmailAlreadyExistsException e){
        model.addAttribute("error",e.getMessage());
        model.addAttribute("userData",new UserDto());
        return "register-user";
    }

}
