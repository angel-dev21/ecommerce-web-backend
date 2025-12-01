package com.example.ecommerceweb.cartitem.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.ecommerceweb.cart.entity.CartEntity;
import com.example.ecommerceweb.productsku.entity.ProductSkuEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart_item")
public class CartItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int quantity;
	
	@CreationTimestamp
	@Column(name="added_at", updatable = false)
	private LocalDateTime addedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cart_id")
	private CartEntity cart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "products_sku_id")
	private ProductSkuEntity productSku;
}
