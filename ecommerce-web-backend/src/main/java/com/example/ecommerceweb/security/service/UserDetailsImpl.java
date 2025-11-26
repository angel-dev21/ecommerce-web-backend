package com.example.ecommerceweb.security.service;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ecommerceweb.user.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

public class UserDetailsImpl implements UserDetails {

	@Serial
	private static final long serialVersionUID = 1L;

	@Getter
	private final long id;
	private final String username;
	@JsonIgnore
	private String password;

	private final Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(long id, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(UserEntity user) {
		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole().getAuthority()));
		return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
