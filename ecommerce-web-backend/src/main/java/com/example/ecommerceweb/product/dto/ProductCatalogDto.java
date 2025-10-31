package com.example.ecommerceweb.product.dto;

import java.util.List;

import com.example.ecommerceweb.productsku.dto.ProductSkuCatalogDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCatalogDto {
	
	@NotNull
	private String name;
	private String cover;
	private List<ProductSkuCatalogDto> productSkuCatalogDto;

}
