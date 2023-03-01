package com.cougar.service;

import java.util.List;

import com.cougar.entity.OrderDetail;

public interface OrderDetailService {

	OrderDetail create(OrderDetail od);

	List<OrderDetail> getOrderDetailByShopId(Integer shopId);

	OrderDetail update(OrderDetail orderDetail);

	void deleteById(Integer id);


}
