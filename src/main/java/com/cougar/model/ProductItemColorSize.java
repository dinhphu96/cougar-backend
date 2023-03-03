package com.cougar.model;

import com.cougar.entity.ProductItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductItemColorSize {
	
	ProductItem productItem;
	String color;
	String size;
	
}
