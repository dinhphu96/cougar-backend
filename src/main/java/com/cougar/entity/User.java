package com.cougar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String password;
	String fullname;
	String phone;
	String email;
	@Temporal(TemporalType.DATE)
	Date createDate = new Date();
	String avatar;
	String resetPasswordToken;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Authority> authorities;
	

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Review> reviews;
	

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<UserPaymentMethod> userPaymentMethod;
	

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Address> Address;
	

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<ProductWishlist> productWishlists;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<ShopOrder> shopOrders;
}
