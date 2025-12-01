package com.example.ecommerceweb.cartitem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceweb.cartitem.dto.CartItemDto;
import com.example.ecommerceweb.cartitem.service.CartItemService;

@RestController
@RequestMapping("/cart")
public class CartItemController {
	
	private final CartItemService cartItemService;
	
	public CartItemController(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}
	
	@PostMapping("/addItem")
	public ResponseEntity<Void> addItem(@RequestBody CartItemDto cartItemDto){
		cartItemService.addCartItem(cartItemDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
