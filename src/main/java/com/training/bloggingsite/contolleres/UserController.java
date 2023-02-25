package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.repositories.RoleRepository;
import com.training.bloggingsite.services.interfaces.RoleService;
import com.training.bloggingsite.services.interfaces.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }

    @GetMapping("/user/home")
    public String getUser(){
        return "user-dashboard";
    }

    @GetMapping("/admin/home")
    public String getAdmin(){
        return "admin-dashboard";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterUser(){
        ModelAndView mav = new ModelAndView("register-user");
        mav.addObject("userData",new UserDto());
        return mav;
    }

    @PostMapping("/register/save")
    public String postRegisterUser(@Valid @ModelAttribute("userData")UserDto userDto, BindingResult result){

        if(result.hasErrors()){
            logger.error(String.valueOf(result));
            return "redirect:/register";
        }

        this.userService.addUser(userDto);
        return "redirect:/login"; // change this at the time of security implementation
    }

    @GetMapping("admin/user/view-users")
    public ModelAndView viewUserList(){
        List<UserDto> users = this.userService.getAllUsers();
        ModelAndView mav = new ModelAndView("view-users");
        mav.addObject("users",users);
        return mav;
    }

    @GetMapping("/admin/user/view")
    public ModelAndView viewUser(@RequestParam("id")long id){
        UserDto userDto = this.userService.getUserById(id);
        List<RoleDto> roles = this.roleService.getAllRoles();
        ModelAndView mav = new ModelAndView("view-user");
        mav.addObject("roles",roles);
        mav.addObject("user",userDto);
        return mav;
    }

}



