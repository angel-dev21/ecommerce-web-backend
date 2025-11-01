package com.example.ecommerceweb.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	@GetMapping("/Catalog")
	public ResponseEntity<List<ProductCatalogDto>> getAllProductCatalog(){
		return new ResponseEntity<> (productService.getAllProductCatalog(), HttpStatus.OK);
	}
	
}