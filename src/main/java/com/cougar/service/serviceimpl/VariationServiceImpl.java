package com.cougar.service.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.VariationDAO;
import com.cougar.entity.Variation;
import com.cougar.service.VariationService;

@Service
public class VariationServiceImpl implements VariationService {

	@Autowired
	VariationDAO variationDAO;

	@Override
	public List<Variation> getVariationsBySubID(Integer subID) {
		// TODO Auto-generated method stub
		return variationDAO.getVariationsBySubID(subID);
	}

	@Override
	public List<Variation> getAll() {
		// TODO Auto-generated method stub
		return variationDAO.findAll();
	}
	

}
