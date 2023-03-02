package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.RoleDto;
import java.util.List;

public interface RoleService {

     RoleDto addRole(RoleDto roleDto);

     List<RoleDto> findAllRoles();

     void deleteRole(int id);


}
