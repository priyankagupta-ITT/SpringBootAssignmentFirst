package com.springboot.jpa.SpringBootAssignmentFirst.repositories;

import com.springboot.jpa.SpringBootAssignmentFirst.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRoleName(String role);
}
