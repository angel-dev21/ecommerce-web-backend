package com.example.ecommerceweb.user.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerceweb.cart.entity.CartEntity;
import com.example.ecommerceweb.security.jwt.JwtUtils;
import com.example.ecommerceweb.user.dto.LoginDto;
import com.example.ecommerceweb.user.dto.RegisterDto;
import com.example.ecommerceweb.user.entity.Role;
import com.example.ecommerceweb.user.entity.UserEntity;
import com.example.ecommerceweb.user.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authManager;
	private final JwtUtils jwtUtils;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authManager, JwtUtils jwtUtils) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authManager = authManager;
		this.jwtUtils = jwtUtils;
	}

	@Transactional
	public void registerUser(RegisterDto registerDto) {
		if (userRepository.existsByEmail(registerDto.getEmail())) {
			throw new RuntimeException("Email ya registrado.");
		}
		if (userRepository.existsByUsername(registerDto.getUsername())) {
			throw new RuntimeException("Nombre de usuario ya registrado.");
		}
		UserEntity user = new UserEntity();
		CartEntity cart = new CartEntity();
		user.setFirstName(registerDto.getFirstName());
		user.setLastName(registerDto.getLastName());
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		user.setBirthDate(registerDto.getBirthDate());
		user.setPhoneNumber(registerDto.getPhoneNumber());
		user.setRole(Role.USER);
		cart.setUser(user);
		user.setCart(cart);
		userRepository.save(user);
	}

	@Transactional
	public String loginUser(LoginDto loginDto) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),
				loginDto.getPassword());
		Authentication auth = authManager.authenticate(authToken);
		if (auth.isAuthenticated()) {
			return jwtUtils.createJwtTokenFromUsername(loginDto.getUsername());
		} else {
			throw new UsernameNotFoundException("Invalid request.");
		}
	}

}
