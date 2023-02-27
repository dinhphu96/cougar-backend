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
	User user;
	
	@ManyToOne
	@JoinColumn(name = "payment_type_id")
	PaymentType paymentType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userPaymentMethod")
	List<ShopOrder> shopOrders;
}
