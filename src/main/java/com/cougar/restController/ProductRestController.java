package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Product;
import com.cougar.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductRestController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/rest/products")
	public List<Product> getAll() {
		return productService.findAll();
	}
	
	@GetMapping("/rest/products/{id}")
	public Product getOne(Model model, @PathVariable("id") Integer id) {
		return productService.findById(id);
	}
	
	@PostMapping("/rest/products")
	public Product create(@RequestBody Product pr) {
		return productService.save(pr);
	}
	
	@PutMapping("/rest/products/{id}")
	public Product update(@PathVariable("id") Integer id, @RequestBody Product pr) {
		return productService.update(pr);
	}
	
	@DeleteMapping("/rest/products/{id}")
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}
}
