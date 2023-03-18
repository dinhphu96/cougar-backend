package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ReviewDAO;
import com.cougar.entity.Review;
import com.cougar.service.ReviewService;
@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewDAO reviewDAO;
	
	@Override
	public Review save(Review reviewSave) {		
		return reviewDAO.save(reviewSave);
	}

}
