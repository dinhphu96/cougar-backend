package com.cougar.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String password;
	String fullname;
	String phone;
	String email;
	@Temporal(TemporalType.DATE)
	Date createDate = new Date();
	String avatar;
	String resetPasswordToken;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Authorities",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<RoleLogin> roles = new ArrayList<>();
    @JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Review> reviews;
	

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<UserPaymentMethod> userPaymentMethod;
	

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Address> Address;
	

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<ProductWishlist> productWishlists;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<ShopOrder> shopOrders;
}