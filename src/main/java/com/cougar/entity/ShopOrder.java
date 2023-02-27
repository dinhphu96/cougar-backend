package com.cougar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
