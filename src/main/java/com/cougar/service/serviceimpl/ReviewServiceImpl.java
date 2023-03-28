package com.cougar.service.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.DAO.ReviewDAO;
import com.cougar.entity.Review;
import com.cougar.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDAO;

	@Override
	public Review save(Review reviewSave) {
		return reviewDAO.save(reviewSave);
	}

	@Override
	public List<Review> getReviewByProduct(Integer productItem) {
		return reviewDAO.getListReviewByProductItemId(productItem);
	}

	@Override
	public boolean isProductReviewedByUser(Integer user, Integer productItem) {
		Review existingReview = reviewDAO.findByUserAndProductItem(user, productItem);
		return existingReview != null;
	}

	@Override
	public void update(String comment, Integer ratingValue, Integer reviewId) {
		reviewDAO.updateById(comment, ratingValue, new Date(), reviewId);
	}

}
