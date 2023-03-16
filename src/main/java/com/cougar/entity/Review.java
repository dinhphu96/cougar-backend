package com.cougar.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Reviews")
public class Review implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Float ratingValue;
	String comment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	UserLogin user;
	
	@ManyToOne
	@JoinColumn(name = "product_item_id")
	ProductItem productItem;
}
