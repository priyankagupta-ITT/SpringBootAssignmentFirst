package com.springboot.jpa.SpringBootAssignmentFirst.repositories;

import com.springboot.jpa.SpringBootAssignmentFirst.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
         List<Department> findByactiveStatus(String status);

        List<Department> findBydnameContaining(String keyword);

}
