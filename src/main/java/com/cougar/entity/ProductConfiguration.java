package com.cougar.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Product_configuration", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "product_item_id", "option_id" }) })
public class ProductConfiguration implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@ManyToOne
	@JoinColumn(name = "product_item_id")
	ProductItem productItem;
	
	@ManyToOne
	@JoinColumn(name = "option_id")
	Option option;
}
