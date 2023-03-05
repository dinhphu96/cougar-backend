package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.DeliveryMethod;
import com.cougar.service.DeliveryMethodService;

@CrossOrigin("*")
@RestController
public class DeliveryMethodRestController {

	@Autowired
	DeliveryMethodService deliveryMethodService;
	
	
	@GetMapping("/rest/deliveryMethods")
	public List<DeliveryMethod> getAll(){
		return deliveryMethodService.getAll();
	}
}
