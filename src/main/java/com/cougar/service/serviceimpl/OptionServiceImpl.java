package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cougar.DAO.OptionDAO;
import com.cougar.service.OptionService;

public class OptionServiceImpl implements OptionService{
	@Autowired OptionDAO optionDAO;
}
