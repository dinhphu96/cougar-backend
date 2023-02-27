package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.OptionDAO;
import com.cougar.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService{
	@Autowired OptionDAO optionDAO;
}
