package com.training.bloggingsite.utils;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.entities.Role;

public class RoleConvertor {

    public static final Role toRole(RoleDto roleDto){
        return new Role(roleDto.getId(),roleDto.getName());
    }

    public static final RoleDto toRoleDto(Role role){
        return new RoleDto((int) role.getId(), role.getName());
    }

}
