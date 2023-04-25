package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.DeliveryMethod;
import com.cougar.service.DeliveryMethodService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/deliveryMethods")
public class DeliveryMethodRestController {

	@Autowired
	DeliveryMethodService deliveryMethodService;
	
	
	@GetMapping("")
	public List<DeliveryMethod> getAll(){
		return deliveryMethodService.getAll();
	}
}
