package com.example.ecommerceweb.address.entity;

import com.example.ecommerceweb.user.entity.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "addresses")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	@Column(name = "address_line_1", nullable = false)
	private String addressLineOne;
	@Column(name = "address_line_2", nullable = false)
	private String addressLineTwo;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private String city;
	@Column(name = "postal_code", nullable = false)
	private String postalCode;
	private String landmark;
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;
	
}
