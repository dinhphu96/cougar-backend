package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.ShopOrder;
import com.cougar.service.ShopOrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/shopOrders")
public class ShopOrderRestController {
	@Autowired ShopOrderService shopOrderService;
	
	@GetMapping("")
	public List<ShopOrder> getAll() {
		return shopOrderService.findAll();
	}
	
}
