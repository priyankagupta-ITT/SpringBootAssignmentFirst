package com.springboot.jpa.SpringBootAssignmentFirst.services;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.RoleDto;

public interface RoleService {
    RoleDto findByRoleName(String role);
}
