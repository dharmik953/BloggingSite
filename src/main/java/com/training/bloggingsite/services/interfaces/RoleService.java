package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.entities.Role;

import java.util.List;

public interface RoleService {

    public RoleDto addRole(RoleDto roleDto);

    public List<RoleDto> findAllRoles();

    public void deleteRole(int id);

    public RoleDto findRoleById(int id);

    public RoleDto findRoleByName(String roleName);

}
