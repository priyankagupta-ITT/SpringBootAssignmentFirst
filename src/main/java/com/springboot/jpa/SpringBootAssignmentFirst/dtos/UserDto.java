package com.springboot.jpa.SpringBootAssignmentFirst.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {
    private int userId;

    @NotBlank(message = "User name is required !!")
    private String name;

    @NotBlank(message = "User email is required !!")
    private String email;

    @Size(min = 3 , max = 10)
    private String password;

    private String gender;

    private String about;

    private Set<RoleDto> roles = new HashSet<>();
}
