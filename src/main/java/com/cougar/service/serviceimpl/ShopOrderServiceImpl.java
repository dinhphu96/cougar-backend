package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ShopOrderDAO;
import com.cougar.entity.ShopOrder;
import com.cougar.service.ShopOrderService;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

	@Autowired
	ShopOrderDAO shopOrderDAO;

	@Override
	public ShopOrder create(ShopOrder so) {
		// TODO Auto-generated method stub
		return shopOrderDAO.save(so);
	}

	@Override
	public ShopOrder findCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return shopOrderDAO.findCartByUserId(userId);
	}

}
