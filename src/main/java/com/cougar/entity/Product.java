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
@Table(name = "Products")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	@Temporal(TemporalType.DATE)
	Date createDate = new Date();
	String description;
	String image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<ProductItem> productItems;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<PromotionProduct> promotionProducts;
	
	@ManyToOne
	@JoinColumn(name = "subcategory_id")
	Subcategory Subcategory;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	Brand brand;
}
