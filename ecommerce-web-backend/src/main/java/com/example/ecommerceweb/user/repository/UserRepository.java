package com.example.ecommerceweb.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerceweb.user.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
	UserEntity findByUsername(String username);
}
