package com.springboot.jpa.SpringBootAssignmentFirst.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RoleDto {
    private int id;

    private String roleName;
}
