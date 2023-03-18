package com.cougar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity 
@Table(name = "Reviews")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Review{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@ManyToOne(targetEntity = UserLogin.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	UserLogin user;
	
	@ManyToOne(targetEntity = ProductItem.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_item_id")
	ProductItem productItem;
	
	@Column(name="rating_value")
	Float ratingValue;
	
	@Column(name="comment")
	String comment;

	public Review() {
	}

	public Review(UserLogin user, ProductItem productItem,Float ratingValue, String comment ) {
		this.user = user;
		this.productItem = productItem;
		this.ratingValue = ratingValue;
		this.comment = comment;		
	}
	
	@Override
	public String toString() {
	    return "Review{" +
	            "id=" + id +
	            ", ratingValue=" + ratingValue +
	            ", comment='" + comment + '\'' +
	            ", user=" + user.getId() + 
	            ", productItem=" + productItem.getId() +
	            '}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserLogin getUser() {
		return user;
	}

	public void setUser(UserLogin user) {
		this.user = user;
	}
	
	@JsonIgnore
	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public Float getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(Float ratingValue) {
		this.ratingValue = ratingValue;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
}
