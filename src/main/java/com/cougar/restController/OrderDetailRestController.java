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

import com.cougar.entity.OrderDetail;
import com.cougar.service.OrderDetailService;

@CrossOrigin("*")
@RestController
public class OrderDetailRestController {
	
	@Autowired
	OrderDetailService orderDetailService;

	@PostMapping("/rest/orderDetails")
	public OrderDetail cretate(@RequestBody OrderDetail od) {
		return orderDetailService.create(od);
	}
	
	
	@GetMapping("/rest/orderDetails/{id}")
	public List<OrderDetail> getOrderDetailByShopId(@PathVariable("id") Integer shopId) {
		return orderDetailService.getOrderDetailByShopId(shopId);
	}
	
	
	@GetMapping("/rest/orderDetails/all/{userId}")
	public List<OrderDetail> getAllOrderDetailByUserId(@PathVariable("userId") Integer userId){
		return orderDetailService.findAllByUserId(userId);
	}
	
	@PutMapping("/rest/orderDetails/{oDID}")
	public OrderDetail update(@PathVariable("oDID") Integer oDID, @RequestBody OrderDetail orderDetail) {
		
		return orderDetailService.update(orderDetail);
	}
	
	@DeleteMapping("/rest/orderDetails/{id}")
	public void delete(@PathVariable("id") Integer id) {
		orderDetailService.deleteById(id);
	}
	
	@GetMapping("/rest/orderDetails")
	public List<OrderDetail> getAll() {
		return orderDetailService.findAll();
	}
}
