package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.OrderDetailDAO;
import com.cougar.entity.OrderDetail;
import com.cougar.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderDetailDAO orderDetailDAO;

	@Override
	public OrderDetail create(OrderDetail od) {
		// TODO Auto-generated method stub
		return orderDetailDAO.save(od);
	}

	@Override
	public List<OrderDetail> getOrderDetailByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		return orderDetailDAO.getOrderDetailByShopId(shopId);
	}

	@Override
	public OrderDetail update(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDetailDAO.save(orderDetail);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		orderDetailDAO.deleteById(id);
	}

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return orderDetailDAO.findAll();
	}

	@Override
	public List<OrderDetail> findAllByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return orderDetailDAO.findAllDetailByUserId(userId);
	}

}
