package com.springboot.jpa.SpringBootAssignmentFirst;

import com.springboot.jpa.SpringBootAssignmentFirst.dtos.RoleDto;
import com.springboot.jpa.SpringBootAssignmentFirst.entities.Role;
import com.springboot.jpa.SpringBootAssignmentFirst.repositories.RoleRepository;
import com.springboot.jpa.SpringBootAssignmentFirst.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootAssignmentFirstApplication  {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignmentFirstApplication.class, args);
	}

}
