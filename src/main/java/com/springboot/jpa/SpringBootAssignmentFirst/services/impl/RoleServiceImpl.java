package com.springboot.jpa.SpringBootAssignmentFirst.services.impl;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.RoleDto;
import com.springboot.jpa.SpringBootAssignmentFirst.entities.Role;
import com.springboot.jpa.SpringBootAssignmentFirst.exceptions.ResourceNotFoundException;
import com.springboot.jpa.SpringBootAssignmentFirst.repositories.RoleRepository;
import com.springboot.jpa.SpringBootAssignmentFirst.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper mapper;

    public RoleDto findByRoleName(String role){
        Role role1 = roleRepository.findByRoleName(role).orElseThrow(()-> new ResourceNotFoundException("role not found"));
        return mapper.map(role1,RoleDto.class);

    }
}
