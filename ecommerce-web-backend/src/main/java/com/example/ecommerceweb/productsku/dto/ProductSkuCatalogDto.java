package com.example.ecommerceweb.productsku.dto;

import java.util.List;

import com.example.ecommerceweb.productattribute.dto.ProductAttributeDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductSkuCatalogDto {

	@NotNull
	private double price;
	private List<ProductAttributeDto> productAttributeDto;
	
}
