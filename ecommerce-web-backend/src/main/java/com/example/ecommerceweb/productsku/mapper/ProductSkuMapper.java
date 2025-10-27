package com.example.ecommerceweb.productsku.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.ecommerceweb.product.dto.ProductCatalogDto;
import com.example.ecommerceweb.product.entity.ProductEntity;
import com.example.ecommerceweb.productattribute.dto.ProductAttributeDto;
import com.example.ecommerceweb.productattribute.entity.ProductAttribute;
import com.example.ecommerceweb.productsku.dto.ProductSkuCatalogDto;
import com.example.ecommerceweb.productsku.entity.ProductSkuEntity;

public class ProductSkuMapper {
	
	public static ProductCatalogDto productEntityToCatalogDto(ProductEntity productEntity) {
		ProductCatalogDto productCatalogDto = new ProductCatalogDto();
		productCatalogDto.setName(productEntity.getName());
		productCatalogDto.setCover(productEntity.getCover());
		return productCatalogDto;
	}
	
	public static List<ProductAttributeDto> productAttributeToDto(ProductSkuEntity productSkuEntity) {
		List<ProductAttribute> productAttribute = productSkuEntity.getProductAttribute();
		List<ProductAttributeDto> productAttributeDto = productAttribute.stream().map(productAtt -> new ProductAttributeDto(productAtt.getType(),productAtt.getValue())).collect(Collectors.toList());
		return productAttributeDto;
	}
	
	public static ProductSkuCatalogDto productSkuEntityToCatalogDto(ProductSkuEntity productSkuEntity) {
		ProductSkuCatalogDto productSkuCatalogDto = new ProductSkuCatalogDto();
		productSkuCatalogDto.setPrice(productSkuEntity.getPrice());
		productSkuCatalogDto.setProductAttributeDto(productAttributeToDto(productSkuEntity));
		productSkuCatalogDto.setProductCatalogDto(productEntityToCatalogDto(productSkuEntity.getProductEntity()));
		return productSkuCatalogDto;
	}
		
}
