//package com.cougar.security;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.cougar.entity.UserLogin;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.Data;
//
//
//@SuppressWarnings("serial")
//@Data
//public class UserDetailsImpl implements UserDetails {
//
//	/**
//	 * 
//	 */
//	
//	private Integer id;
//	private String fullname;
//	private String email;
//	private String phone;
//	@JsonIgnore
//	private String password;
//	private String avatar;	
//	private Date createDate;
//	private String resetPasswordToken;
//	private Collection<? extends GrantedAuthority> authorities;
//	
//	
//
////	public UserDetailsImpl(Integer id, String fullname, String email, String password, String phone, String avatar,
////			Collection<? extends GrantedAuthority> authorities) {
////		this.id = id;
////		this.fullname = fullname;
////		this.email = email;
////		this.password = password;
////		this.phone = phone;
////		this.avatar = avatar;		
////		this.authorities = authorities;
////	}
//	
//	
//	public UserDetailsImpl(Integer id, String fullname, String email, String phone, String password, String avatar,
//			Date createDate, String resetPasswordToken, Collection<? extends GrantedAuthority> authorities) {
//		this.id = id;
//		this.fullname = fullname;
//		this.email = email;
//		this.phone = phone;
//		this.password = password;
//		this.avatar = avatar;
//		this.createDate = createDate;
//		this.resetPasswordToken = resetPasswordToken;
//		this.authorities = authorities;
//	}
//
//	public static UserDetailsImpl build(UserLogin user) {
//		List<GrantedAuthority> authorities = user.getRoles().stream()
//				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//
//		return new UserDetailsImpl(
//				user.getId(), 
//				user.getFullname(), 
//				user.getEmail(),
//				user.getPhone(),
//				user.getPassword(), 
//				user.getAvatar(),
//				user.getCreateDate(),
//				user.getResetPasswordToken(),
//				authorities);
//	}
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return fullname;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	
//}
