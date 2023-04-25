package com.cougar.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.OrderDetail;
import com.cougar.entity.ProductItem;
import com.cougar.entity.ShopOrder;
import com.cougar.model.ShopOrderOrderDetail;
import com.cougar.service.OrderDetailService;
import com.cougar.service.ProductItemService;
import com.cougar.service.ShopOrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/shopOrders")
public class ShopOrderRestController {
	
	@Autowired
	ShopOrderService shopOrderService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	ProductItemService productItemService;
	
	@GetMapping("")
	public List<ShopOrder> getAll() {
		return shopOrderService.findAll();
	}
	
	@PostMapping("")
	public ShopOrderOrderDetail cretate(@RequestBody ShopOrderOrderDetail sod) {
		ShopOrder shop = shopOrderService.create(sod.getShopOrder());
		OrderDetail orderDetail = sod.getOrderDetail();
		orderDetail.setShopOrder(shop);
		ShopOrderOrderDetail shopOr = new ShopOrderOrderDetail(shop, orderDetailService.create(orderDetail));
		
		return shopOr;
	}
	
	@GetMapping("/{userId}")
	public ShopOrder findCartByUserId(@PathVariable("userId") Integer userId) {
		return shopOrderService.findCartByUserId(userId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		shopOrderService.deleteById(id);
	}
	
	@PutMapping("/{orderId}")
	public ShopOrder updateShopOrder(@PathVariable("orderId") Integer orderId,@RequestBody ShopOrder order) {
		return shopOrderService.updateShopOrder(order);
	}
	
	@PutMapping("/changeStatus")
	public ShopOrder changeStatus(@RequestBody ShopOrder shopOrder) {
		if (shopOrder.getOrderStatus() == 3) {
			List<OrderDetail> orderDetails = orderDetailService.findAll();
			
			for (OrderDetail orderDetail : orderDetails) {
				ProductItem prodItem = orderDetail.getProductItem();
				Integer temp = prodItem.getQtyInStock();
				prodItem.setQtyInStock(temp - orderDetail.getQty());
				productItemService.save(prodItem);
			}
		}
		return shopOrderService.changeStatus(shopOrder);
	}
	
	@GetMapping("/all/{userId}")
	public List<ShopOrder> getAllOrderByUserId(@PathVariable("userId") Integer userId){
		return shopOrderService.getAllByUserId(userId);
	}
}
