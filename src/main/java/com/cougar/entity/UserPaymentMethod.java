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
@Table(name = "User_payment_method")
public class UserPaymentMethod implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String provider;
	String accountNumber;
	@Temporal(TemporalType.DATE)
	Date expiryDate;
	Boolean isDefault;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	UserLogin user;
	
	@ManyToOne
	@JoinColumn(name = "payment_type_id")
	PaymentType paymentType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userPaymentMethod")
	List<ShopOrder> shopOrders;
}
