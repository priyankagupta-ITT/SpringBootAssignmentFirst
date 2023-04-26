package com.springboot.jpa.SpringBootAssignmentFirst.dtos;


import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
   private int id;

   @NotBlank(message = "Department name is required !!")
    private String dname;

    @NotBlank(message = "status  is required !!")
    private String activeStatus;
}
