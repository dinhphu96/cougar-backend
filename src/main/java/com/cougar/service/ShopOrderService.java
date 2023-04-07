package com.cougar.service;

import java.util.List;

import com.cougar.entity.ShopOrder;

public interface ShopOrderService {

	ShopOrder create(ShopOrder so);

	ShopOrder findCartByUserId(Integer userId);
	
	List<ShopOrder> findAll();

	void deleteById(Integer id);

	ShopOrder updateShopOrder(ShopOrder order);

	ShopOrder changeStatus(ShopOrder shopOrder);
	
	List<ShopOrder> getAllByUserId(Integer userId);
}
