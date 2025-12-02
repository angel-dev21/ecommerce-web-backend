package com.example.ecommerceweb.product.dto;

import java.util.List;

import com.example.ecommerceweb.productsku.dto.ProductSkuDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
	
	@NotEmpty(message = "Invalid name.")
	private String name;
	private String cover;
	private List<ProductSkuDto> productSkuDto;

}
