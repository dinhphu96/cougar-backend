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
		return shopOrderDAO.save(so);
	}

	@Override
	public ShopOrder findCartByUserId(Integer userId) {
		return shopOrderDAO.findCartByUserId(userId);
	}

	@Override
	public void deleteById(Integer id) {
		shopOrderDAO.deleteById(id);
	}

	@Override
	public ShopOrder updateShopOrder(ShopOrder order) {
		return shopOrderDAO.save(order);
	}

	@Override
	public ShopOrder changeStatus(ShopOrder shopOrder) {
		return shopOrderDAO.save(shopOrder);
	}

	@Override
	public List<ShopOrder> getAllByUserId(Integer userId) {		
		return shopOrderDAO.findByUserId(userId);
	}

}
