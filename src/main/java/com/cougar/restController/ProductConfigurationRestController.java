package com.cougar.restController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.ProductConfiguration;
import com.cougar.service.ProductConfigurationService;

@CrossOrigin("*")
@RestController
public class ProductConfigurationRestController {
	
	@Autowired
	ProductConfigurationService productConfigurationService;
	
	@GetMapping("/rest/productConfigurations/{productItemId}")
	public List<ProductConfiguration> getListOptionByProductItemId(@PathVariable("productItemId") Integer productItemId){
		return productConfigurationService.findByProductItemId(productItemId);
	}
	
	@PostMapping("/api/productConfigurations")
	public void create(@RequestBody ProductConfiguration con) {
		productConfigurationService.save(con);
	}
	
	@PostMapping("/api/productConfigurations/createNewItem")
	public ProductConfiguration createNewItem(@RequestBody ProductConfiguration con) {
		return productConfigurationService.saveNewItem(con);
	}
	
	@GetMapping("/api/productConfigurations")
	public List<ProductConfiguration> getAll(){
		return productConfigurationService.getAll();
	}
	
	@PutMapping("/api/productConfigurations")
	public ProductConfiguration update(@RequestBody ProductConfiguration con){
		return productConfigurationService.update(con);
	}
}
