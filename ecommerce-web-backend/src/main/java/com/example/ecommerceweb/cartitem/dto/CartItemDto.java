package com.example.ecommerceweb.cartitem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItemDto {

	private long cartId;
	private long productSkuId;
	private int quantity;
	
}
