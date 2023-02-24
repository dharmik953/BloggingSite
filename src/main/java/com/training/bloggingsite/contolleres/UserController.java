package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("user/register-user")
    public ModelAndView getRegisterUser() {
        ModelAndView mav = new ModelAndView("register-user");
        mav.addObject("userData", new UserDto());
        return mav;
    }

    @PostMapping("user/register-user-save")
    public String postRegisterUser(@ModelAttribute("userData") UserDto userDto) {
        this.userService.addUser(userDto);
        return "redirect:/admin/user/view-users"; // change this at the time of security implementation
    }

    @GetMapping("admin/user/view-users")
    public ModelAndView viewRoleList() {
        List<UserDto> users = this.userService.getAllUsers();
        ModelAndView mav = new ModelAndView("view-users");
        mav.addObject("users", users);
        return mav;
    }

    @GetMapping("admin/user/delete-user")
    public String deleteUser(@RequestParam("user") long id) {
        this.userService.deleteUser(id);
        return "redirect:/admin/user/view-users";
    }

    @GetMapping("admin/user/update-user")
    public ModelAndView getupdateUser(@RequestParam("user") long id) {
        ModelAndView mav = new ModelAndView("update-user");
        UserDto userDto = this.userService.getUserById(id);
        mav.addObject("userData", userDto);
        return mav;
    }
}



