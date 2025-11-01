package com.example.ecommerceweb.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerceweb.user.dto.RegisterDto;
import com.example.ecommerceweb.user.entity.UserEntity;
import com.example.ecommerceweb.user.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public UserEntity registerUser(RegisterDto registerDto) {
		if(userRepository.existsByEmail(registerDto.getEmail())) {
			throw new RuntimeException("Email ya registrado.");
		}
		if(userRepository.existsByUsername(registerDto.getUsername())) {
			throw new RuntimeException("Nombre de usuario ya registrado.");
		}
		UserEntity user = new UserEntity();
		user.setFirstName(registerDto.getFirstName());
		user.setLastName(registerDto.getLastName());
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		user.setBirthDate(registerDto.getBirthDate());
		user.setPhoneNumber(registerDto.getPhoneNumber());
		return userRepository.save(user);
	}

	
}
