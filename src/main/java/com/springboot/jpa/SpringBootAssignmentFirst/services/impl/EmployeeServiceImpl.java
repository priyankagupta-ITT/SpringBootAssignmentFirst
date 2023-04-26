package com.springboot.jpa.SpringBootAssignmentFirst.services.impl;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.DepartmentDto;
import com.springboot.jpa.SpringBootAssignmentFirst.dtos.EmployeeDto;
import com.springboot.jpa.SpringBootAssignmentFirst.entities.Department;
import com.springboot.jpa.SpringBootAssignmentFirst.entities.Employee;
import com.springboot.jpa.SpringBootAssignmentFirst.exceptions.ResourceNotFoundException;
import com.springboot.jpa.SpringBootAssignmentFirst.repositories.DepartmentRepository;
import com.springboot.jpa.SpringBootAssignmentFirst.repositories.EmployeeRepository;
import com.springboot.jpa.SpringBootAssignmentFirst.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = dtoToEntity(employeeDto);
        Employee savedEmployee= employeeRepository.save(employee);
        EmployeeDto newEmployeeDto = entityToDto(savedEmployee);
        return newEmployeeDto;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, int empId) {
        Employee employee= employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this given Id"));
        employee.setEName(employeeDto.getEName());
        employee.setActiveStatus(employeeDto.getActiveStatus());
        employee.setEmail(employeeDto.getEmail());
        Employee updatedEmployee= employeeRepository.save(employee);
        EmployeeDto updatedEmployeeDto = entityToDto(updatedEmployee);
        return updatedEmployeeDto;
    }

    @Override
    public void deleteEmployee(int empId) {
        Employee employee= employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this given Id"));
        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employee= employeeRepository.findAll();
       List<EmployeeDto> employeeDtoList =employee.stream().map(employee1 -> entityToDto(employee1)).collect(Collectors.toList());
        return employeeDtoList;
    }

    @Override
    public EmployeeDto getEmployeeById(int empId) {
        Employee employee= employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this given Id"));
        return entityToDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeByEmail(String empEmail) {
        Employee employee= employeeRepository.findByEmail(empEmail).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this given Id"));
        return entityToDto(employee);
    }

    @Override
    public List<EmployeeDto> searchEmployee(String keyword) {
        List<Employee> employeesList = employeeRepository.findByeNameContaining(keyword);
        List<EmployeeDto> employeeDtoList =employeesList.stream().map(employee1 -> entityToDto(employee1)).collect(Collectors.toList());
        return employeeDtoList;
    }

    @Override
    public EmployeeDto createEmpWithDept(EmployeeDto employeeDto, int deptId) {
         Department department = departmentRepository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("dept not found with given id"));
        Employee employee = dtoToEntity(employeeDto);
        employee.setDepartment(department);
        Employee savedEmployee= employeeRepository.save(employee);
        return entityToDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateDepartment(int empId, int deptId) {
        Employee employee= employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this given Id"));
        Department department = departmentRepository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("dept not found with given id"));
        employee.setDepartment(department);
        Employee updatedEmployee= employeeRepository.save(employee);
        return entityToDto(updatedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmpOfDept(int deptId) {
        Department departmentDto = departmentRepository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("department not found"));
        List<Employee> employeesList = employeeRepository.findByDepartment(departmentDto);
        List<EmployeeDto> employeeDtoList =employeesList.stream().map(employee1 -> entityToDto(employee1)).collect(Collectors.toList());
        return employeeDtoList;
    }

    @Override
    public List<EmployeeDto> findByactiveStatus(String status) {
        List<Employee> employeesList = employeeRepository.findByactiveStatus(status);
        List<EmployeeDto> employeeDtoList =employeesList.stream().map(employee1 -> entityToDto(employee1)).collect(Collectors.toList());
        return employeeDtoList;
    }


    private EmployeeDto entityToDto(Employee savedEmployee) {
        return mapper.map(savedEmployee,EmployeeDto.class);
    }

    private Employee dtoToEntity(EmployeeDto employeeDto) {
        return mapper.map(employeeDto,Employee.class);
    }
}