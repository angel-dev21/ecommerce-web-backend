package com.example.ecommerceweb.user.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
	@Email(message = "Invalid email.")
	private String email;
	@NotEmpty(message = "Invalid password.")
	@Size(min = 8, max = 20, message = "Invalid password size.")
	private String password;
	@Past
	private LocalDate birthDate;
	private String phoneNumber;
}
