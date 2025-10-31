package com.example.ecommerceweb.address.dto;

import com.example.ecommerceweb.user.entity.UserEntity;

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

	@NotNull
	private String addressLineOne;
	@NotNull
	private String addressLineTwo;
	@NotNull
	private String country;
	@NotNull
	private String city;
	@NotNull
	private String postalCode;
	private String landmark;
	@NotNull
	private String phoneNumber;
	private UserEntity user;
	
}
