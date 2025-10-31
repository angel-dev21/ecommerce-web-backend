package com.example.ecommerceweb.user.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.ecommerceweb.address.entity.AddressEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(name = "date_of_birth")
	private LocalDate birthDate;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@OneToOne(mappedBy = "user")
	private AddressEntity address;
	
}