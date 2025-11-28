package com.example.ecommerceweb.product.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceweb.product.dto.ProductCatalogDto;
import com.example.ecommerceweb.product.repository.ProductRepository;
import com.example.ecommerceweb.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService, ProductRepository productRepository) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<Page<ProductCatalogDto>> getAllProducts(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int size,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "true") boolean order) {
		Sort sort = order ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return new ResponseEntity<>(productService.getAllProducts(pageable), HttpStatus.OK);
	}

}