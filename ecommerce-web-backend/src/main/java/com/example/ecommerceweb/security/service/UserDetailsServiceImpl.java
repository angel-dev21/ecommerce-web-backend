package com.example.ecommerceweb.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecommerceweb.user.entity.UserEntity;
import com.example.ecommerceweb.user.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Usario no encontrado.");
		}

		return UserDetailsImpl.build(user);
	}

}
