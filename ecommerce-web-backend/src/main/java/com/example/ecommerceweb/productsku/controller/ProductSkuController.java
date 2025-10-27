package com.example.ecommerceweb.productsku.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceweb.productsku.dto.ProductSkuCatalogDto;
import com.example.ecommerceweb.productsku.service.ProductSkuService;

@RestController
@RequestMapping("/productSku")
public class ProductSkuController {

	private final ProductSkuService productSkuService;
	
	public ProductSkuController (ProductSkuService productSkuService) {
		this.productSkuService = productSkuService;
	}
	
	@GetMapping("/getSku/{id}")
	public ResponseEntity<ProductSkuCatalogDto> getProductSkuById(@PathVariable long id){
		return new ResponseEntity<> (productSkuService.getProductSkuCatalogDtoById(id), HttpStatus.OK);
	}
	
	@GetMapping("/getAllSku")
	public ResponseEntity<List<ProductSkuCatalogDto>> getAllProductSku(){
		return new ResponseEntity<> (productSkuService.getAllProductSkuCatalogDto(), HttpStatus.OK);
	}
}
