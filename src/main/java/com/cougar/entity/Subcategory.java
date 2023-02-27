package com.cougar.entity;

import java.io.Serializable;
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
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Subcategories")
public class Subcategory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subcategory")
	List<Product> products;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subcategory")
	List<Variation> variations;
}
