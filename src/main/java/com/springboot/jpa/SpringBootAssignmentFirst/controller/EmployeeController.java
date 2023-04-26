package com.springboot.jpa.SpringBootAssignmentFirst.controller;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.EmployeeDto;
import com.springboot.jpa.SpringBootAssignmentFirst.payload.ApiResponse;
import com.springboot.jpa.SpringBootAssignmentFirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto, @PathVariable("empId") int empId){
        EmployeeDto updateEmployeeDto = employeeService.updateEmployee(employeeDto,empId);
        return new ResponseEntity<>(updateEmployeeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable int empId){
       employeeService.deleteEmployee(empId);
       ApiResponse apiResponse =ApiResponse.builder().message("Employee is deleted successfully").success(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
    }


    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("empId") int empId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<EmployeeDto> getEmployeeByEmail(@PathVariable String email){
        EmployeeDto employeeDto = employeeService.getEmployeeByEmail(email);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<EmployeeDto>> searchEmployee(@PathVariable String keywords){
        List<EmployeeDto> employeeDto = employeeService.searchEmployee(keywords);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/active/{status}")
    public  ResponseEntity<List<EmployeeDto>> getActiveEmployee(@PathVariable String status){
       List<EmployeeDto> employeeDtoList = employeeService.findByactiveStatus(status);
       return new ResponseEntity<>(employeeDtoList,HttpStatus.OK);
    }

}
