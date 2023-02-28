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
	Subcategory subcategory;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	Brand brand;
}
