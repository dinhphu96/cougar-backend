package com.cougar.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authorities", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "role_id" }) })
public class Authority implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@ManyToOne
	@JoinColumn(name = "role_id")
	Role role;

	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;
	
	@Override
	public String toString() {
		return "Authority{" +
				"id=" + id +
				", role=" + role.getName() +
				", user=" + user.getEmail() +
				'}';
	}
}
