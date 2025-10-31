package com.example.ecommerceweb.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerceweb.user.dto.UserDto;
import com.example.ecommerceweb.user.entity.UserEntity;
import com.example.ecommerceweb.user.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public UserEntity registerUser(UserDto userDto) {
		if(userRepository.existsByEmail(userDto.getEmail())) {
			throw new RuntimeException("Email ya registrado.");
		}
		UserEntity user = new UserEntity();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setBirthDate(userDto.getBirthDate());
		user.setPhoneNumber(userDto.getPhoneNumber());
		return userRepository.save(user);
	}
}
