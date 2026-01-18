package com.example.ecommerceweb.product.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceweb.product.dto.ProductDto;
import com.example.ecommerceweb.product.repository.ProductRepository;
import com.example.ecommerceweb.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService, ProductRepository productRepository) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<PagedModel<ProductDto>> getAllProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "4") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "true") boolean order) {
		Sort sort = order ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		PagedModel<ProductDto> pagedModel = new PagedModel<>(productService.getAllProducts(pageable));
		return new ResponseEntity<>(pagedModel, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
		return new ResponseEntity<ProductDto>(productService.getProduct(id), HttpStatus.OK);
	}

}