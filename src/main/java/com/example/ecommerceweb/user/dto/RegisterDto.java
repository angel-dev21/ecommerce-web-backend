package com.example.ecommerceweb.user.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterDto {

	private String firstName;
	private String lastName;
	@NotEmpty(message = "Invalid username.")
	@Size(min = 4, max = 20, message = "Invalid username size.")
	private String username;
	@NotEmpty(message = "Invalid email.")
	@Email(message = "Invalid email format.")
	private String email;
	@NotEmpty(message = "Invalid password.")
	@Size(min = 8, max = 20, message = "Invalid password size.")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).{8,}$", message = "Invalid password format.")
	private String password;
	@Past
	private LocalDate birthDate;
	private String phoneNumber;
}
