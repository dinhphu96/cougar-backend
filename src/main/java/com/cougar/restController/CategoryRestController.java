package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Category;
import com.cougar.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryRestController {
	@Autowired CategoryService categoryService;
	
	@GetMapping("")
	public List<Category> getAll() {
		return categoryService.findAll();
	}
}
