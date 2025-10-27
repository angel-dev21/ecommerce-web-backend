package com.example.ecommerceweb.productsku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerceweb.productsku.entity.ProductSkuEntity;

@Repository
public interface ProductSkuRepository extends JpaRepository<ProductSkuEntity, Long> {

}
