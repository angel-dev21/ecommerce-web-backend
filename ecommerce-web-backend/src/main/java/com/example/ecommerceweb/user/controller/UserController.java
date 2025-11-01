package com.example.ecommerceweb.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceweb.user.dto.LoginDto;
import com.example.ecommerceweb.user.dto.RegisterDto;
import com.example.ecommerceweb.user.entity.UserEntity;
import com.example.ecommerceweb.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AuthenticationManager authManager;

	private UserService userService;
	
	public UserController(UserService userService, AuthenticationManager authManager) {
		this.userService = userService;
		this.authManager = authManager;
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> registerUser(@RequestBody RegisterDto registerDto) {
		return new ResponseEntity<>(userService.registerUser(registerDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
		try {
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
			org.springframework.security.core.Authentication auth = authManager.authenticate(authToken);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return ResponseEntity.ok("Usuario logueado.");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al loguearse.");
		}
	}
	
}
