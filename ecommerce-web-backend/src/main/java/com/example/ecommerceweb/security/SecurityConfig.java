package com.example.ecommerceweb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.ecommerceweb.security.service.UserDetailsServiceImpl;
import com.example.ecommerceweb.user.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final UserDetailsServiceImpl userDetailsServiceImpl;
	
	public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/user/**").permitAll()
				.requestMatchers("/products/**").permitAll()
				.anyRequest().authenticated()
			).httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	AuthenticationProvider authProvider(){
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsServiceImpl);
		return authProvider;
	} 
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
