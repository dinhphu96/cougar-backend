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
