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
@Table(name = "Promotions")
public class Promotion implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String description;
	Integer discountRate;
	@Temporal(TemporalType.DATE)
	Date startDate = new Date();
	@Temporal(TemporalType.DATE)
	Date endDate = new Date();
	
	@JsonIgnore
	@OneToMany(mappedBy = "promotion")
	List<PromotionProduct> promotionProducts;
}
