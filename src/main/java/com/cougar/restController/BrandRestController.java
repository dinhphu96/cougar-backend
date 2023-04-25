package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Brand;
import com.cougar.service.BrandService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/brands")
public class BrandRestController {
	
	@Autowired
	BrandService brandService;

	@GetMapping("")
	public List<Brand> getAll(){
		return brandService.getAll();
	}
}
