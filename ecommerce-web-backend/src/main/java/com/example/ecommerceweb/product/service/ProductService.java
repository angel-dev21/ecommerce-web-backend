package com.example.ecommerceweb.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ecommerceweb.product.dto.ProductCatalogDto;
import com.example.ecommerceweb.product.entity.ProductEntity;
import com.example.ecommerceweb.product.mapper.ProductMapper;
import com.example.ecommerceweb.product.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<ProductCatalogDto> getAllProductCatalog(){
		List<ProductEntity> productEntity = productRepository.findAll();
		List<ProductCatalogDto> productCatalogDto = productEntity.stream().map(product -> ProductMapper.productEntityToCatalogDto(product)).collect(Collectors.toList());
		return productCatalogDto;
	}
}
