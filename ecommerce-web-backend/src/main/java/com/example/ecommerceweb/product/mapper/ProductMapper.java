package com.example.ecommerceweb.product.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.ecommerceweb.product.dto.ProductCatalogDto;
import com.example.ecommerceweb.product.entity.ProductEntity;
import com.example.ecommerceweb.productattribute.dto.ProductAttributeDto;
import com.example.ecommerceweb.productattribute.entity.ProductAttribute;
import com.example.ecommerceweb.productsku.dto.ProductSkuCatalogDto;
import com.example.ecommerceweb.productsku.entity.ProductSkuEntity;

public class ProductMapper {
	
	public static ProductCatalogDto productEntityToCatalogDto(ProductEntity productEntity) {
		ProductCatalogDto productCatalogDto = new ProductCatalogDto();
		productCatalogDto.setName(productEntity.getName());
		productCatalogDto.setCover(productEntity.getCover());
		productCatalogDto.setProductSkuCatalogDto(productSkuToCatalogDto(productEntity.getProductSkus()));
		return productCatalogDto;
	}
	
	public static List<ProductSkuCatalogDto> productSkuToCatalogDto(List<ProductSkuEntity> productSkuEntity){
		List<ProductSkuCatalogDto> productSkuCatalogDto = productSkuEntity.stream().map(productSku -> new ProductSkuCatalogDto(productSku.getPrice(),productAttributeToDto(productSku.getProductAttribute()))).collect(Collectors.toList());
		return productSkuCatalogDto;
	}
	
	public static List<ProductAttributeDto> productAttributeToDto(List<ProductAttribute> productAttribute) {
		List<ProductAttributeDto> productAttributeDto = productAttribute.stream().map(productAtt -> new ProductAttributeDto(productAtt.getType(),productAtt.getValue())).collect(Collectors.toList());
		return productAttributeDto;
	}
	
}
