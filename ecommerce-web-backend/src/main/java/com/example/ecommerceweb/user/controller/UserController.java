package com.example.ecommerceweb.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceweb.user.dto.UserDto;
import com.example.ecommerceweb.user.entity.UserEntity;
import com.example.ecommerceweb.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> registerUser(@RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);
	}
}
