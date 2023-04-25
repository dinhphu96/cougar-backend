package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Subcategory;
import com.cougar.service.SubcategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/subCategories")
public class SubCategoryRestController {
	@Autowired SubcategoryService subcategoryService;
	
	@GetMapping("")
	public List<Subcategory> getAll() {
		return subcategoryService.findAll();
	}
}
