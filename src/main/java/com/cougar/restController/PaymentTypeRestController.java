package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.PaymentType;
import com.cougar.service.PaymentTypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/paymentTypes")
public class PaymentTypeRestController {

	@Autowired
	PaymentTypeService paymentTypeService;
	
	@GetMapping("")
	public List<PaymentType> getAlle(){
		return paymentTypeService.getAll();
	}
}
