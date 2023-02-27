package com.cougar.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
