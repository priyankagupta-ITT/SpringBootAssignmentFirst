package com.springboot.jpa.SpringBootAssignmentFirst.services.impl;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.DepartmentDto;
import com.springboot.jpa.SpringBootAssignmentFirst.entities.Department;
import com.springboot.jpa.SpringBootAssignmentFirst.entities.Employee;
import com.springboot.jpa.SpringBootAssignmentFirst.exceptions.ResourceNotFoundException;
import com.springboot.jpa.SpringBootAssignmentFirst.repositories.DepartmentRepository;
import com.springboot.jpa.SpringBootAssignmentFirst.repositories.EmployeeRepository;
import com.springboot.jpa.SpringBootAssignmentFirst.services.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = dtoToEntity(departmentDto);
        return entityToDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, int deptId) {
        Department oldDepartment = departmentRepository.findById(deptId).orElseThrow(()-> new ResourceNotFoundException("Dept not found with this Id to update"));
        oldDepartment.setDname(departmentDto.getDname());
        oldDepartment.setActiveStatus(departmentDto.getActiveStatus());
        return entityToDto(departmentRepository.save(oldDepartment));
    }

    @Override
    public void deleteDepartment(int deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(()-> new ResourceNotFoundException("Dept not found with this Id to delete"));
        List<Employee>  employeeList = employeeRepository.findByDepartment(department);
        boolean anyEmployeeHasStatusTrue = employeeList.stream()
                .anyMatch(employee -> "y".equalsIgnoreCase(employee.getActiveStatus()));
        if(employeeList.size()>0 && anyEmployeeHasStatusTrue){
            department.setActiveStatus("n");
            departmentRepository.save(department);
        }else{
            departmentRepository.delete(department);
        }
    }

    @Override
    public DepartmentDto getDepartmentById(int deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(()-> new ResourceNotFoundException("Dept not found with this Id"));
        return entityToDto(departmentRepository.save(department));
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentDto> departmentDtoList = departmentList.stream().map(department1 -> entityToDto(department1)).collect(Collectors.toList());
        return departmentDtoList;
    }

    @Override
    public List<DepartmentDto> findByactiveStatus(String status) {
        List<Department> departmentList = departmentRepository.findByactiveStatus(status);
        List<DepartmentDto> departmentDtoList = departmentList.stream().map(department1 -> entityToDto(department1)).collect(Collectors.toList());
        return departmentDtoList;
    }

    @Override
    public List<DepartmentDto> searchDepartment(String deptName) {
        List<Department> department = departmentRepository.findBydnameContaining(deptName);
        List<DepartmentDto> departmentDtoList = department.stream().map(department1 -> entityToDto(department1)).collect(Collectors.toList());
        return departmentDtoList;
    }


    private DepartmentDto entityToDto(Department department) {
        return mapper.map(department,DepartmentDto.class);
    }

    private Department dtoToEntity(DepartmentDto departmentDto) {
        return mapper.map(departmentDto,Department.class);
    }
}
