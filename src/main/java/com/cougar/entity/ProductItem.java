package com.cougar.entity;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Product_items")
public class ProductItem implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String SKU;
	@Temporal(TemporalType.DATE)
	Date createDate = new Date();
	Integer qtyInStock;
	Integer price;
	String image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productItem")
	List<Review> reviews;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productItem")
	List<OrderDetail> orderDetails;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productItem")
	List<ProductConfiguration> productConfigurations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productItem")
	List<ProductWishlist> productWishlist;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	Product product;
}
