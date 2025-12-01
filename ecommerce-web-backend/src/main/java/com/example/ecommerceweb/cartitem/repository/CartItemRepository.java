package com.example.ecommerceweb.cartitem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerceweb.cartitem.entity.CartItemEntity;
import com.example.ecommerceweb.productsku.entity.ProductSkuEntity;
import com.example.ecommerceweb.cart.entity.CartEntity;


@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
	public boolean existsByProductSkuAndCart(ProductSkuEntity productSku, CartEntity cart);
	public Optional<CartItemEntity> findByCartAndProductSku(CartEntity cart, ProductSkuEntity productSku);
}
