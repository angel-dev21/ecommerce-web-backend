package com.example.ecommerceweb.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ecommerceweb.user.dto.LoginDto;
import com.example.ecommerceweb.user.dto.RegisterDto;
import com.example.ecommerceweb.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterDto registerDto) {
		userService.registerUser(registerDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@Valid @RequestBody LoginDto loginDto) {
		return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.OK);
	}

	@GetMapping("/username")
	public ResponseEntity<String> getUsername()
	{
		return new ResponseEntity<>(userService.getUsername(), HttpStatus.OK);
	}

}
