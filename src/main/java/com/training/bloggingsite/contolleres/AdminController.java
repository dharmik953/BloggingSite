package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.services.interfaces.RoleService;
import com.training.bloggingsite.services.interfaces.UserService;
import com.training.bloggingsite.utils.DefaultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/admin/home")
    public String getAdmin(Principal principal, Model model){
        UserDto userDto = this.userService.findUserByEmail(principal.getName());
        model.addAttribute("name",userDto.getName());
        return "admin-dashboard";
    }

    @GetMapping("/admin/user/view-users")
    public ModelAndView viewUserList(){
        List<UserDto> users = this.userService.findAllUsers();
        ModelAndView mav = new ModelAndView("view-users");
        mav.addObject("users",users);
        return mav;
    }

    @GetMapping("/admin/user/view")
    public ModelAndView viewUser(@RequestParam("id")long id){
        UserDto userDto = this.userService.findUserById(id);
        List<RoleDto> roles = this.roleService.findAllRoles();
        ModelAndView mav = new ModelAndView("view-user");
        mav.addObject("roles",roles);
        mav.addObject("user",userDto);
        return mav;
    }

    @GetMapping("/admin/user/update-role")
    public String updateUserRole(@RequestParam("id") long id,@RequestParam("role") String role){
        this.userService.updateUserRole(id,role);
        return "redirect:/admin/user/view?id="+id;
    }

}
