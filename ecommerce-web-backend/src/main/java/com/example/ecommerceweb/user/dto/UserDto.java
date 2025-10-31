package com.example.ecommerceweb.user.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private String firstName;
	private String lastName;
	@NotNull
	private String username;
	@NotNull
	private String email;
	@NotNull
	private String password;
	private LocalDate birthDate;
	private String phoneNumber;
}
