package com.springboot.jpa.SpringBootAssignmentFirst.services;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(EmployeeDto employeeDto,int empId);

    void deleteEmployee(int empId);

   List<EmployeeDto> getAllEmployee();

    EmployeeDto getEmployeeById(int empId);

    EmployeeDto getEmployeeByEmail(String empEmail);

    List<EmployeeDto> searchEmployee(String keyword);

    EmployeeDto createEmpWithDept(EmployeeDto employeeDto , int deptId);

    EmployeeDto updateDepartment(int empId, int deptId);

    List<EmployeeDto> getAllEmpOfDept(int deptId);

    List<EmployeeDto> findByactiveStatus(String status);


}
