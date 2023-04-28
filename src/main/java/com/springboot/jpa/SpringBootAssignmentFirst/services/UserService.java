package com.springboot.jpa.SpringBootAssignmentFirst.services;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,int userId);
    UserDto getUser(int userId);
    List<UserDto> getAllUser();
    void deleteUser(int userId);
    UserDto getUserByEmail(String email);
}
