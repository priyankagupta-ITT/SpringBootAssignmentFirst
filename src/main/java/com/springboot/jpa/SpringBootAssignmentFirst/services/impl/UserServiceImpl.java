package com.springboot.jpa.SpringBootAssignmentFirst.services.impl;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.UserDto;
import com.springboot.jpa.SpringBootAssignmentFirst.entities.Role;
import com.springboot.jpa.SpringBootAssignmentFirst.entities.User;
import com.springboot.jpa.SpringBootAssignmentFirst.exceptions.ResourceNotFoundException;
import com.springboot.jpa.SpringBootAssignmentFirst.repositories.RoleRepository;
import com.springboot.jpa.SpringBootAssignmentFirst.repositories.UserRepository;
import com.springboot.jpa.SpringBootAssignmentFirst.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapper.map(userDto,User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByRoleName("ROLE_NORMAL").get();
        user.getRoles().add(role);
        User savedUser = userRepository.save(user);
        return mapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"));
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return mapper.map(user,UserDto.class);
    }

    @Override
    public UserDto getUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"));
        return mapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = userList.stream().map(user -> mapper.map(user,UserDto.class)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"));
        userRepository.delete(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("user not found"));
        return mapper.map(user,UserDto.class);
    }
}
