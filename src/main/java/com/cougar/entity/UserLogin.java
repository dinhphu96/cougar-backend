package com.cougar.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class UserLogin implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    private String fullname;
    private String phone;
    private String email;
	@Temporal(TemporalType.DATE)
	private Date createDate = new Date();
	private String avatar;
	private String resetPasswordToken;
	

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Authorities",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<RoleRegister> roles = new ArrayList<>();
    
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return fullname;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}