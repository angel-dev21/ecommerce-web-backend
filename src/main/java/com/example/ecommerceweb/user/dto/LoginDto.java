package com.example.ecommerceweb.user.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDto {
	
	
	@NotEmpty(message = "Invalid username.")
	@Size(min = 4, max = 20, message = "Invalid username size.")
	private String username;
	@NotEmpty(message = "Invalid password.")
	@Size(min = 8, max = 20, message = "Invalid password size.")
	private String password;
	
}
