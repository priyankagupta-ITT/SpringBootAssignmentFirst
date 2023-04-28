package com.springboot.jpa.SpringBootAssignmentFirst.controller;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.UserDto;
import com.springboot.jpa.SpringBootAssignmentFirst.payload.ApiResponse;
import com.springboot.jpa.SpringBootAssignmentFirst.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.createUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable int userId){
        UserDto userDto1 = userService.updateUser(userDto,userId);
        return new ResponseEntity<>(userDto1, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable int userId){
        UserDto userDto1 = userService.getUser(userId);
        return new ResponseEntity<>(userDto1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> userDtoList = userService.getAllUser();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
        ApiResponse apiResponse = ApiResponse.builder().message("user deleted successfully").status(HttpStatus.OK).success(true).build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String  email){
        UserDto userDto1 = userService.getUserByEmail(email);
        return new ResponseEntity<>(userDto1, HttpStatus.OK);
    }
}
