package com.springboot.jpa.SpringBootAssignmentFirst.dtos;

import com.springboot.jpa.SpringBootAssignmentFirst.validate.NameValid;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private int empId;

    @NameValid
    private String eName;

    @NotBlank(message =  "email is required")
    @Pattern(regexp = "^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+\\.)+[a-z]{2,5}$",message = "Inavlid email")
    private String email;

    @NotBlank(message =  "status is required")
    private String activeStatus;

    private DepartmentDto department;
}
