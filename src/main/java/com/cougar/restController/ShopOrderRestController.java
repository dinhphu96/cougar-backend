package com.cougar.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.ShopOrder;
import com.cougar.service.ShopOrderService;

@CrossOrigin("*")
@RestController
public class ShopOrderRestController {
	
	@Autowired
	ShopOrderService shopOrderService;

	@GetMapping("/rest/shopOrders")
	public List<ShopOrder> getAll() {
		return shopOrderService.findAll();
	}
	
	@PostMapping("/rest/shopOrders")
	public ShopOrder cretate(@RequestBody ShopOrder so) {
		return shopOrderService.create(so);
	}
	
	@GetMapping("/rest/shopOrders/{userId}")
	public ShopOrder findCartByUserId(@PathVariable("userId") Integer userId) {
		return shopOrderService.findCartByUserId(userId);
	}
}
