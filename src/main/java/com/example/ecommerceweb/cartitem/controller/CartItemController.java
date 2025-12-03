package com.example.ecommerceweb.cartitem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PostMapping("/create")
	public ResponseEntity<Void> createCartItem(@RequestBody CartItemDto cartItemDto) {
		cartItemService.createCartItem(cartItemDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/add/{id}")
	public ResponseEntity<Void> addCartItem(@PathVariable long id) {
		cartItemService.addCartItem(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/substract/{id}")
	public ResponseEntity<Void> substractCartItem(@PathVariable long id) {
		cartItemService.substractCartItem(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> removeCartItem(@PathVariable long id) {
		cartItemService.removeCartItem(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
