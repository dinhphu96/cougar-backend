package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.UserPaymentMethod;
import com.cougar.service.UserPaymentMethodService;

@CrossOrigin("*")
@RestController
public class UserPaymentMethodRestController {

	@Autowired
	UserPaymentMethodService paymentMethodService;
	
	@GetMapping("/rest/userPaymentMethods/{userId}")
	public List<UserPaymentMethod> getUserPaymenMethodByUserId(@PathVariable("userId") Integer userId){
		return paymentMethodService.getUserPaymenMethodByUserId(userId);
	}
	
	@PostMapping("/rest/userPaymentMethods")
	public UserPaymentMethod create(@RequestBody UserPaymentMethod userPaymentMethod){
		return paymentMethodService.create(userPaymentMethod);
	}
}
