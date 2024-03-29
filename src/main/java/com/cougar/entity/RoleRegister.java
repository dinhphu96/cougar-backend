package com.cougar.entity;

import java.util.ArrayList;
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
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Roles")
public class RoleRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String name;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "Authorities",
	        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	    private List<UserLogin> users = new ArrayList<>();
	 @Override
	 public String toString() {
	     return "RoleRegister{" +
	             "id=" + id +
	             ", role='" + name + '\'' +
	             ", users=" + ((users == null) ? "null" : users.stream().map(UserLogin::getId).collect(Collectors.toList())) +
	             '}';
	 }
}
