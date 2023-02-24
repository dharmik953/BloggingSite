package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.RoleDto;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.exceptions.RoleAlreadyExistsException;
import com.training.bloggingsite.repositories.RoleRepository;
import com.training.bloggingsite.services.interfaces.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public RoleDto addRole(RoleDto roleDto) {

        Role check= this.roleRepository.findByRole(roleDto.getRole());

        if(check==null) {
            Role roleToBeInserted = toRole(roleDto);
            roleToBeInserted.setRole(roleToBeInserted.getRole().toUpperCase());
            this.roleRepository.save(roleToBeInserted);
            logger.info("Role Added :" + roleDto);
            return roleDto;
        }
        else{
            throw new RoleAlreadyExistsException(roleDto.getRole().toUpperCase());
        }
    }

    @Override
    public List<RoleDto> getAllRoles() {
         List<Role> roles = this.roleRepository.findAll();
         List<RoleDto> roleDtos = new ArrayList<>();
         for (Role role : roles){
             roleDtos.add(toRoleDto(role));
         }
        logger.info("Roles Fetched :"+roleDtos);
         return roleDtos;
    }

    @Override
    public void deleteRole(int id) {
        this.roleRepository.deleteById(id);
        logger.info("Role Deleted with id :"+id);
    }

    @Override
    public RoleDto getRoleById(int id){
        Role role =  this.roleRepository.findById(id).get();
        RoleDto roleDto = toRoleDto(role);
        logger.info("Role fetched :"+roleDto);
        return roleDto;
    }

    @Override
    public RoleDto getRole(String roleDto){
        Role role = this.roleRepository.findByRole(roleDto);
        RoleDto roleDtoData = toRoleDto(role);
        return roleDtoData;
    }

}
