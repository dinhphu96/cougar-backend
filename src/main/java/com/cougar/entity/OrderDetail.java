package com.cougar.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Order_details")
public class OrderDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Integer qty;
	Integer price;
	Date createDate;

	@ManyToOne
	@JoinColumn(name = "product_item_id")
	ProductItem productItem;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	ShopOrder shopOrder;
}
