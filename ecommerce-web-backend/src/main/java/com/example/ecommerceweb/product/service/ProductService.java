package com.example.ecommerceweb.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true)
	public Page<ProductCatalogDto> getAllProducts(Pageable pageable){
		Page<ProductEntity> productEntity = productRepository.findAll(pageable);
		Page<ProductCatalogDto> productCatalogDto = productEntity.map(product -> ProductMapper.productEntityToCatalogDto(product));
		return productCatalogDto;
	}
}
