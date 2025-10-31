package com.example.ecommerceweb.productsku.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ecommerceweb.product.entity.ProductEntity;
import com.example.ecommerceweb.productattribute.entity.ProductAttribute;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products_skus")
public class ProductSkuEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	@Column(nullable = false)
	private String sku;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;
	
	@ManyToMany
	@JoinTable(name = "sku_attributes", joinColumns = @JoinColumn(name = "products_sku_id"), inverseJoinColumns = @JoinColumn(name = "product_attribute_id"))
	private List<ProductAttribute> productAttribute;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
}
