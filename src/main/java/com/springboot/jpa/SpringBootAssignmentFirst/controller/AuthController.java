package com.springboot.jpa.SpringBootAssignmentFirst.controller;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.JwtRequest;
import com.springboot.jpa.SpringBootAssignmentFirst.dtos.JwtResponse;
import com.springboot.jpa.SpringBootAssignmentFirst.dtos.UserDto;
import com.springboot.jpa.SpringBootAssignmentFirst.security.JwtHelper;
import com.springboot.jpa.SpringBootAssignmentFirst.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper helper;

    @GetMapping("/currentUser")
    public ResponseEntity<UserDetails> getCurrentUser(Principal principal){
        String name = principal.getName();
        return new ResponseEntity<>(userDetailsService.loadUserByUsername(name), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
        this.doAuthenticate(request.getEmail(),request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
        UserDto userDto = mapper.map(userDetails,UserDto.class);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .user(userDto).build();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,password);
        try{
            manager.authenticate(authenticationToken);
        }
        catch(BadCredentialsException e){
            throw new BadCredentialsException("Invalid user name or password");
        }
    }

}
