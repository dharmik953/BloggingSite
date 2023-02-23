package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.entities.Role;

import java.util.List;

public interface RoleService {

    default Role toRole(RoleDto roleDto){
        return new Role(roleDto.getId(),roleDto.getRole());
    }

    default RoleDto toRoleDto(Role role){
        return new RoleDto(role.getId(), role.getRole());
    }

    public RoleDto addRole(RoleDto roleDto);

    public List<RoleDto> getAllRoles();

    public void deleteRole(int id);

    public RoleDto getRoleById(int id);

    public RoleDto getRole(String role);

}
