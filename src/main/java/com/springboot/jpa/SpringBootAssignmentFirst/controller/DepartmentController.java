package com.springboot.jpa.SpringBootAssignmentFirst.controller;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.DepartmentDto;
import com.springboot.jpa.SpringBootAssignmentFirst.dtos.EmployeeDto;
import com.springboot.jpa.SpringBootAssignmentFirst.payload.ApiResponse;
import com.springboot.jpa.SpringBootAssignmentFirst.services.DepartmentService;
import com.springboot.jpa.SpringBootAssignmentFirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@Valid  @RequestBody DepartmentDto departmentDto){
       DepartmentDto departmentDto1 = departmentService.createDepartment(departmentDto);
       return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{deptId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@Valid @RequestBody DepartmentDto departmentDto, @PathVariable int deptId){
        DepartmentDto departmentDto1 = departmentService.updateDepartment(departmentDto,deptId);
        return new ResponseEntity<>(departmentDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<ApiResponse> deleteDepartment(@PathVariable int deptId){
        departmentService.deleteDepartment(deptId);
        ApiResponse apiResponse = ApiResponse.builder().message("dept deleted successfully").status(HttpStatus.OK).success(true).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        return new ResponseEntity<>(departmentService.getAllDepartment(),HttpStatus.OK);
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable int deptId){
        DepartmentDto departmentDto1 = departmentService.getDepartmentById(deptId);
        return new ResponseEntity<>(departmentDto1, HttpStatus.OK);
    }

    @GetMapping("/active/{status}")
    public ResponseEntity<List<DepartmentDto>> getActiveDepartment(@PathVariable String status){
        List<DepartmentDto> departmentDtoList = departmentService.findByactiveStatus(status);
        return new ResponseEntity<>(departmentDtoList,HttpStatus.OK);
    }

    @GetMapping("/search/{dname}")
    public ResponseEntity<List<DepartmentDto>> searchDepartment(@PathVariable String dname){
        List<DepartmentDto> departmentDtoList = departmentService.searchDepartment(dname);
        return new ResponseEntity<>(departmentDtoList,HttpStatus.OK);
    }

    @PostMapping("/{deptId}/employee")
    public ResponseEntity<EmployeeDto> createEmployeeWithDepartment(
            @PathVariable int deptId,
            @RequestBody EmployeeDto employeeDto
    ){
      EmployeeDto employeeDtoWithDept = employeeService.createEmpWithDept(employeeDto,deptId);
      return new ResponseEntity<>(employeeDtoWithDept,HttpStatus.CREATED);

    }

    @PutMapping("/{deptId}/employee/{empId}")
    public ResponseEntity<EmployeeDto> updateDepartmentInEmployee(
            @PathVariable int deptId,
            @PathVariable int empId
    ){
        EmployeeDto employeeDto = employeeService.updateDepartment(empId,deptId);
        return  new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    @GetMapping("/{deptId}/employee")
    public ResponseEntity<List<EmployeeDto>> getEmployeeForDepartment(@PathVariable int deptId){
        return new ResponseEntity<>(employeeService.getAllEmpOfDept(deptId),HttpStatus.OK);
    }

}
