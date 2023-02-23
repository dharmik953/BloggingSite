package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.services.interfaces.UserService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    LoggerFactory.getLogger(UserController.class);

    @GetMapping("register")
    public String getAddUser(Model model){
        logger.info("Registration Model");
        model.addAttribute("userData",new UserDto());
        return "register";
    }

    @PostMapping("registerProcessing")
    public String postAddUser(@Valid @ModelAttribute("userData") UserDto userDto,BindingResult result,Model model){

        if(result.hasErrors()){
          return "register";
        }

        this.userService.addUser(userDto);
        return "redirect:register";
    }

}
