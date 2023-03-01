package com.cougar.service;

import com.cougar.entity.ShopOrder;

public interface ShopOrderService {

	ShopOrder create(ShopOrder so);

	ShopOrder findCartByUserId(Integer userId);

}
