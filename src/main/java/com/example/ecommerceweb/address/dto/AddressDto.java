package com.example.ecommerceweb.address.dto;

import com.example.ecommerceweb.user.entity.UserEntity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddressDto {

	@NotEmpty(message = "Invalid address.")
	private String addressLineOne;
	@NotEmpty(message = "Invalid address.")
	private String addressLineTwo;
	@NotEmpty(message = "Invalid country.")
	private String country;
	@NotEmpty(message = "Invalid city.")
	private String city;
	@NotEmpty(message = "Invalid postal code.")
	private String postalCode;
	private String landmark;
	@NotEmpty(message = "Invalid phone number.")
	private String phoneNumber;
	@NotNull(message = "Invalid user.")
	private UserEntity user;
	
}
