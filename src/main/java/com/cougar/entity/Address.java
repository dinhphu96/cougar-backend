package com.cougar.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
