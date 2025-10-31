package com.example.ecommerceweb.productattribute.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductAttributeDto {
	@NotNull
	private String type;
	@NotNull
	private String value;
}
