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
@Table(name = "Shop_orders")
public class ShopOrder implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Temporal(TemporalType.DATE)
	Date createDate = new Date();
	Integer orderTotal;
	Boolean orderStatus = null;
	
	@ManyToOne
	@JoinColumn(name = "user_payment_method_id")
	UserPaymentMethod userPaymentMethod;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	Address address;
	
	@ManyToOne
	@JoinColumn(name = "delivery_method_id")
	DeliveryMethod deliveryMethod;
	
	@JsonIgnore
	@OneToMany(mappedBy = "shopOrder")
	List<OrderDetail> orderDetails;
}
