package com.cougar.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.DATE)
	Date createDate = new Date();

	@ManyToOne
	@JoinColumn(name = "product_item_id")
	ProductItem productItem;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	ShopOrder shopOrder;
}
