package com.training.bloggingsite.contolleres;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.services.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("admin/add-role")
    public ModelAndView getaddRole(){
        ModelAndView mav = new ModelAndView("add-role");
        mav.addObject("roleData", new RoleDto());
        return mav;
    }

    @PostMapping("admin/add-role-save")
    public String postAddRole(@ModelAttribute("roleData") RoleDto roleDto){
        this.roleService.addRole(roleDto);
        return "redirect:/admin/view-role";
    }

    @GetMapping("admin/view-role")
    public ModelAndView viewRoleList(){
        List<RoleDto> roles = this.roleService.getAllRoles();
        ModelAndView mav = new ModelAndView("view-role");
        mav.addObject("roles",roles);
        return mav;
    }

    @GetMapping("admin/delete-role")
    public String deleteRole(@RequestParam("role")int id){
        this.roleService.deleteRole(id);
        return "redirect:/admin/view-role";

    }

    @GetMapping("admin/update-role")
    public ModelAndView updateRole(@RequestParam("role")int id){
        ModelAndView mav = new ModelAndView("add-role");
        RoleDto roleDto = this.roleService.getRoleById(id);
        mav.addObject("roleData",roleDto);
        return mav;
    }


}
