package com.cougar.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Addresses")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Integer unitNumber;
	String addressLine;
	String district;
	String province;
	String countryName;
	Boolean isDefault;

	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	@JsonIgnore
	@OneToMany(mappedBy = "address")
	List<ShopOrder> shopOrders;
}
