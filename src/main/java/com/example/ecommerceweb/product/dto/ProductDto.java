package com.example.ecommerceweb.product.dto;

import java.util.List;

import com.example.ecommerceweb.productsku.dto.ProductSkuDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
	
	@NotNull
	private long id;
	@NotEmpty(message = "Invalid name.")
	private String name;
	private String brand;
	private List<ProductSkuDto> productSkuDto;

}
