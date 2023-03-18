package com.cougar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Table(name = "Reviews")
@Data
public class Review{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "product_item_id")
	ProductItem productItem;

	Float ratingValue;
	
	String comment;
	
}
