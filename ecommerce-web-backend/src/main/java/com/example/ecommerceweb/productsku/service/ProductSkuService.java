package com.example.ecommerceweb.productsku.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ecommerceweb.productsku.dto.ProductSkuCatalogDto;
import com.example.ecommerceweb.productsku.entity.ProductSkuEntity;
import com.example.ecommerceweb.productsku.mapper.ProductSkuMapper;
import com.example.ecommerceweb.productsku.repository.ProductSkuRepository;

@Service
public class ProductSkuService {

	private final ProductSkuRepository productSkuRepository;
	
	public ProductSkuService(ProductSkuRepository productSkuRepository) {
		this.productSkuRepository = productSkuRepository;
	}

	public ProductSkuCatalogDto getProductSkuCatalogDtoById(long id) {
		Optional<ProductSkuEntity> optionalProductSku = productSkuRepository.findById(id);
		ProductSkuEntity productSku = optionalProductSku.get();
		ProductSkuCatalogDto productSkuCatalogDto = ProductSkuMapper.productSkuEntityToCatalogDto(productSku);
		return productSkuCatalogDto;
	}
	
	public List<ProductSkuCatalogDto> getAllProductSkuCatalogDto(){
		List<ProductSkuCatalogDto> allProductSku = new ArrayList<>();
		allProductSku = productSkuRepository.findAll().stream().map(productSku -> ProductSkuMapper.productSkuEntityToCatalogDto(productSku)).collect(Collectors.toList());
		return allProductSku;
	}
}
