package com.cougar.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.OptionDAO;
import com.cougar.entity.Option;
import com.cougar.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService{
	@Autowired OptionDAO optionDAO;
	@Override
	public List<Option> findAll() {
		return optionDAO.findAll();
	}
	@Override
	public Option create(Option option) {
		// TODO Auto-generated method stub
		return optionDAO.save(option);
	}
}
