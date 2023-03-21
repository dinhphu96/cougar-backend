package com.cougar.service;

import java.util.List;

import com.cougar.entity.Review;

public interface ReviewService {
	Review save(Review reviewSave);
	List<Review> getReviewByProduct(Integer productItem);
}
