package com.example.ecommerceweb.productattribute.dto;

import com.example.ecommerceweb.productattribute.entity.ProductAttributeType;

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
	@NotNull(message = "Invalid type.")
	private ProductAttributeType type;
	@NotNull(message = "Invalid value.")
	private String value;
}
