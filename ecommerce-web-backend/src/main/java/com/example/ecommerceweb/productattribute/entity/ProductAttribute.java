package com.example.ecommerceweb.productattribute.entity;

import java.util.List;

import com.example.ecommerceweb.productsku.entity.ProductSkuEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "product_attributes")
public class ProductAttribute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
	private String value;
	
	@ManyToMany(mappedBy = "productAttribute")
	private List<ProductSkuEntity> productSku;
}
