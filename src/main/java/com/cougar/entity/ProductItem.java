package com.cougar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
