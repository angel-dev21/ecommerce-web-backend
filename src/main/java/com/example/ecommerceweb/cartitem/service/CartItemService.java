package com.example.ecommerceweb.cartitem.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ecommerceweb.cart.entity.CartEntity;
import com.example.ecommerceweb.cart.repository.CartRepository;
import com.example.ecommerceweb.cartitem.dto.CartItemDto;
import com.example.ecommerceweb.cartitem.entity.CartItemEntity;
import com.example.ecommerceweb.cartitem.repository.CartItemRepository;
import com.example.ecommerceweb.productsku.entity.ProductSkuEntity;
import com.example.ecommerceweb.productsku.repository.ProductSkuRepository;

import jakarta.transaction.Transactional;

@Service
public class CartItemService {

	private final CartItemRepository cartItemRepository;
	private final ProductSkuRepository productSkuRepository;
	private final CartRepository cartRepository;

	public CartItemService(CartItemRepository cartItemRepository, ProductSkuRepository productSkuRepository,
			CartRepository cartRepository) {
		this.cartItemRepository = cartItemRepository;
		this.productSkuRepository = productSkuRepository;
		this.cartRepository = cartRepository;
	}

	@Transactional
	public void createCartItem(CartItemDto cartItemDto) {
		int quantity = cartItemDto.getQuantity();
		long cartId = cartItemDto.getCartId();
		long productSkuId = cartItemDto.getProductSkuId();
		BigDecimal bigQuantity = new BigDecimal(quantity);
		Optional<ProductSkuEntity> productSku = productSkuRepository.findById(productSkuId);
		if (productSku.isEmpty()) {
			throw new IllegalArgumentException("Product doesn't exists.");
		}
		if (quantity > productSku.get().getQuantity() || quantity <= 0) {
			throw new IllegalArgumentException("Error in quantity value.");
		}
		Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
		if (cartEntity.isEmpty()) {
			throw new IllegalArgumentException("Cart doesn't exists.");
		}
		Optional<CartItemEntity> alreadyCreated = cartItemRepository.findByCartAndProductSku(cartEntity.get(),
				productSku.get());
		if (alreadyCreated.isPresent()) {
			if (quantity + alreadyCreated.get().getQuantity() > productSku.get().getQuantity()) {
				throw new IllegalArgumentException("Error in quantity value.");
			} else {
				CartEntity cartCreated = alreadyCreated.get().getCart();
				ProductSkuEntity productSkuCreated = alreadyCreated.get().getProductSku();
				alreadyCreated.get().setQuantity(quantity + alreadyCreated.get().getQuantity());
				BigDecimal newTotal = cartCreated.getTotal().add(bigQuantity.multiply(productSkuCreated.getPrice()));
				cartCreated.setTotal(newTotal);
			}
		} else {
			CartItemEntity cartItem = new CartItemEntity();
			cartItem.setQuantity(quantity);
			cartItem.setCart(cartEntity.get());
			cartItem.setProductSku(productSku.get());

			BigDecimal newTotal = cartEntity.get().getTotal().add(bigQuantity.multiply(productSku.get().getPrice()));
			cartEntity.get().setTotal(newTotal);

			cartItemRepository.save(cartItem);
		}
	}

	@Transactional
	public void substractCartItem(long id) {
		Optional<CartItemEntity> cartItem = cartItemRepository.findById(id);
		if (cartItem.isEmpty()) {
			throw new IllegalArgumentException("Cart Item not found.");
		}
		Optional<ProductSkuEntity> productSku = productSkuRepository.findById(cartItem.get().getProductSku().getId());
		if (productSku.isEmpty()) {
			throw new IllegalArgumentException("Product Sku not found.");
		}
		if (cartItem.get().getQuantity() - 1 <= 0) {
			removeCartItem(id);
		} else {
			cartItem.get().setQuantity(cartItem.get().getQuantity() - 1);

			BigDecimal newTotal = cartItem.get().getCart().getTotal().subtract(productSku.get().getPrice());

			cartItem.get().getCart().setTotal(newTotal);
		}
	}

	@Transactional
	public void addCartItem(long id) {
		Optional<CartItemEntity> cartItem = cartItemRepository.findById(id);
		if (cartItem.isEmpty()) {
			throw new IllegalArgumentException("Cart Item not found.");
		}
		Optional<ProductSkuEntity> productSku = productSkuRepository.findById(cartItem.get().getProductSku().getId());
		if (productSku.isEmpty()) {
			throw new IllegalArgumentException("Product Sku not found.");
		}
		if (cartItem.get().getQuantity() + 1 > productSku.get().getQuantity()) {
			throw new IllegalArgumentException("Quantity error.");
		} else {
			cartItem.get().setQuantity(cartItem.get().getQuantity() + 1);

			BigDecimal newTotal = cartItem.get().getCart().getTotal().add(productSku.get().getPrice());

			cartItem.get().getCart().setTotal(newTotal);
		}
	}

	@Transactional
	public void removeCartItem(long id) {
		Optional<CartItemEntity> cartItem = cartItemRepository.findById(id);
		if (cartItem.isEmpty()) {
			throw new IllegalArgumentException("Cart Item not found.");
		}
		Optional<ProductSkuEntity> productSku = productSkuRepository.findById(cartItem.get().getProductSku().getId());
		if (productSku.isEmpty()) {
			throw new IllegalArgumentException("Product Sku not found.");
		}

		BigDecimal cartQuantity = new BigDecimal(cartItem.get().getQuantity());
		BigDecimal newTotal = cartItem.get().getCart().getTotal()
				.subtract(cartQuantity.multiply(cartItem.get().getProductSku().getPrice()));
		
		cartItem.get().getCart().setTotal(newTotal);

		if (cartItem.get().getProductSku().getPrice().compareTo(new BigDecimal("0")) <= 0) {
			cartItem.get().getCart().setTotal(new BigDecimal("0"));
		}
		cartItemRepository.deleteById(id);
	}
}
