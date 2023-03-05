package com.cougar.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.OrderDetail;
import com.cougar.entity.ShopOrder;
import com.cougar.model.ShopOrderOrderDetail;
import com.cougar.service.OrderDetailService;
import com.cougar.service.ShopOrderService;

@CrossOrigin("*")
@RestController
public class ShopOrderRestController {
	
	@Autowired
	ShopOrderService shopOrderService;
	@Autowired
	OrderDetailService orderDetailService;

	@GetMapping("/rest/shopOrders")
	public List<ShopOrder> getAll() {
		return shopOrderService.findAll();
	}
	
	@PostMapping("/rest/shopOrders")
	public ShopOrderOrderDetail cretate(@RequestBody ShopOrderOrderDetail sod) {
		ShopOrder shop = shopOrderService.create(sod.getShopOrder());
		OrderDetail orderDetail = sod.getOrderDetail();
		orderDetail.setShopOrder(shop);
		ShopOrderOrderDetail shopOr = new ShopOrderOrderDetail(shop, orderDetailService.create(orderDetail));
		
		return shopOr;
	}
	
	@GetMapping("/rest/shopOrders/{userId}")
	public ShopOrder findCartByUserId(@PathVariable("userId") Integer userId) {
		return shopOrderService.findCartByUserId(userId);
	}
	
	@DeleteMapping("/rest/shopOrders/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		shopOrderService.deleteById(id);
	}
	
	@PutMapping("/rest/shopOrders/{orderId}")
	public ShopOrder updateShopOrder(@PathVariable("orderId") Integer orderId,@RequestBody ShopOrder order) {
		return shopOrderService.updateShopOrder(order);
	}
}
