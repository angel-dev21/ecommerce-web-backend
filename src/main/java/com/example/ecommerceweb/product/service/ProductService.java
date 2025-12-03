package com.example.ecommerceweb.product.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerceweb.product.dto.ProductDto;
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
	public Page<ProductDto> getAllProducts(Pageable pageable) {
		Page<ProductEntity> productEntity = productRepository.findAll(pageable);
		Page<ProductDto> productDto = productEntity.map(product -> ProductMapper.productEntityToDto(product));
		return productDto;
	}

	@Transactional
	public ProductDto getProduct(long id) {
		Optional<ProductEntity> product = productRepository.findById(id);
		if (product.isEmpty()) {
			throw new IllegalArgumentException("Product not found");
		}
		ProductDto productDto = ProductMapper.productEntityToDto(product.get());
		return productDto;
	}
}
