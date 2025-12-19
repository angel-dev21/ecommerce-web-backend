package com.example.ecommerceweb.product.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.ecommerceweb.product.dto.ProductDto;
import com.example.ecommerceweb.product.entity.ProductEntity;
import com.example.ecommerceweb.productattribute.dto.ProductAttributeDto;
import com.example.ecommerceweb.productattribute.entity.ProductAttribute;
import com.example.ecommerceweb.productsku.dto.ProductSkuDto;
import com.example.ecommerceweb.productsku.entity.ProductSkuEntity;

public class ProductMapper {
	
	public static ProductDto productEntityToDto(ProductEntity productEntity) {
		ProductDto productDto = new ProductDto();
		productDto.setId(productEntity.getId());
		productDto.setName(productEntity.getName());
		productDto.setCover(productEntity.getCover());
		productDto.setProductSkuDto(productSkuToDto(productEntity.getProductSkus()));
		return productDto;
	}
	
	public static List<ProductSkuDto> productSkuToDto(List<ProductSkuEntity> productSkuEntity){
		List<ProductSkuDto> productSkuDto = productSkuEntity.stream().map(productSku -> new ProductSkuDto(productSku.getId(),productSku.getPrice(),productAttributeToDto(productSku.getProductAttribute()))).collect(Collectors.toList());
		return productSkuDto;
	}
	
	public static List<ProductAttributeDto> productAttributeToDto(List<ProductAttribute> productAttribute) {
		List<ProductAttributeDto> productAttributeDto = productAttribute.stream().map(productAtt -> new ProductAttributeDto(productAtt.getType(),productAtt.getValue())).collect(Collectors.toList());
		return productAttributeDto;
	}
	
}
