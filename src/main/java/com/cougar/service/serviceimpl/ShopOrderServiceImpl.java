package com.cougar.service.serviceimpl;

import java.util.List;

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
	public List<ShopOrder> findAll() {
		return shopOrderDAO.findAll();
	}

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

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		shopOrderDAO.deleteById(id);
	}
}
