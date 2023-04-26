package com.springboot.jpa.SpringBootAssignmentFirst.services;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto updateDepartment(DepartmentDto departmentDto, int deptId);

    void deleteDepartment(int deptId);

    DepartmentDto getDepartmentById(int deptId);

    List<DepartmentDto> getAllDepartment();

    List<DepartmentDto> findByactiveStatus(String status);

    List<DepartmentDto> searchDepartment(String  deptName);


}
