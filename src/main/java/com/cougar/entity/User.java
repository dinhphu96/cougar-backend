package com.cougar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@JsonIgnore
	String password;
	String fullname;
	String phone;
	String email;
	@Temporal(TemporalType.DATE)
	Date createDate = new Date();
	String avatar;
	
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
	
	@Override
	public String toString() {
	    return "User{" +
	            "id=" + id +
	            ", password='" + password + '\'' +
	            ", fullname='" + fullname + '\'' +
	            ", phone='" + phone + '\'' +
	            ", email='" + email + '\'' +
	            ", avatar='" + avatar + '\'' +
	            ", authorities=" + authorities +
	            '}';
	}

}
