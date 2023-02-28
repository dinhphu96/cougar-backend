package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.ProductItem;
import com.cougar.service.ProductItemService;

@CrossOrigin("*")
@RestController
public class ProductItemRestController {
	@Autowired
	ProductItemService productItemService;
	
	
	@GetMapping("/rest/productItems")
	public List<ProductItem> getAll() {
		return productItemService.findAll();
	}
	
	@GetMapping("/rest/productItems/{id}")
	public ProductItem getOne(@PathVariable("id") Integer id) {
		return productItemService.findById(id);
	}
	
	@PostMapping("/rest/productItems")
	public ProductItem create(@RequestBody ProductItem prI) {
		return productItemService.save(prI);
	}
	
	@PutMapping("/rest/productItems/{id}")
	public ProductItem update(@PathVariable("id") Integer id, @RequestBody ProductItem prI) {
		return productItemService.update(prI);
	}
	
	@DeleteMapping("/rest/productItems/{id}")
	public void delete(@PathVariable("id") Integer id) {
		productItemService.delete(id);
	}

}
