package com.cougar.service;

import java.util.List;

import com.cougar.entity.ShopOrder;

public interface ShopOrderService {

	ShopOrder create(ShopOrder so);

	ShopOrder findCartByUserId(Integer userId);
	
	List<ShopOrder> findAll();

}
