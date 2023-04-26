package com.springboot.jpa.SpringBootAssignmentFirst.repositories;

import com.springboot.jpa.SpringBootAssignmentFirst.entities.Department;
import com.springboot.jpa.SpringBootAssignmentFirst.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByEmail(String empEmail);

    List<Employee> findByeNameContaining(String keywords);

    List<Employee> findByDepartment(Department department);

    List<Employee> findByactiveStatus(String status);
}
