package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.services.interfaces.RoleService;
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

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    // Add new Role.
    @GetMapping("admin/add-role")
    public ModelAndView getaddRole(){
        ModelAndView mav = new ModelAndView("add-role");
        mav.addObject("roleData",new RoleDto());
        return mav;
    }

    // Save new Role to database.
    @PostMapping("admin/add-role-save")
    public String postAddRole(@Valid  @ModelAttribute("roleData") RoleDto roleDto, BindingResult
                              result){
        if(result.hasErrors()){
            logger.error(String.valueOf(result));
            return "redirect:/admin/add-role";
        }
        this.roleService.addRole(roleDto);
        return "redirect:/admin/view-role";
    }

    // Displaying all roles from database.
    @GetMapping("admin/view-role")
    public ModelAndView viewRoleList(){
        List<RoleDto> roles = this.roleService.findAllRoles();
        ModelAndView mav = new ModelAndView("view-role");
        mav.addObject("roles",roles);
        return mav;
    }

    // Delete the selected role.
    @GetMapping("admin/delete-role")
    public String deleteRole(@RequestParam("role")int role){
        this.roleService.deleteRole(role);
        return "redirect:/admin/view-role";
    }

}
