package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.entities.Role;

import java.util.List;

public interface RoleService {

    default Role toRole(RoleDto roleDto){
        return new Role(roleDto.getId(),roleDto.getName());
    }

    default RoleDto toRoleDto(Role role){
        return new RoleDto((int) role.getId(), role.getName());
    }

    public RoleDto addRole(RoleDto roleDto);

    public List<RoleDto> getAllRoles();

    public void deleteRole(int id);

    public RoleDto getRoleById(int id);

    public RoleDto getRole(String role);

}
