package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Review;
import com.cougar.service.ReviewService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/review")
public class ReviewRestController {
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/{productId}")
	public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable Integer productId) {
	    List<Review> reviews = reviewService.getReviewByProduct(productId);
	    if (reviews.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    System.out.println(reviews);
	    return ResponseEntity.ok(reviews);
	}
	
	@PostMapping("/send")
	public Review createReview(@RequestBody Review review) {
	  return reviewService.save(review);
	}
	
}
