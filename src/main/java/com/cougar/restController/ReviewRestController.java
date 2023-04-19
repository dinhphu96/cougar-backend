package com.cougar.restController;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.ProductItem;
import com.cougar.entity.Review;
import com.cougar.entity.User;
import com.cougar.payload.response.MessageResponse;
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
		return ResponseEntity.ok(reviews);
	}

	@PostMapping("/send")
	public ResponseEntity<?> createReview(@RequestBody Review review) {
		User user = review.getUser();
		ProductItem productItem = review.getProductItem();
		if (reviewService.isProductReviewedByUser(user.getId(), productItem.getId())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: User has already reviewed this product!"));
		} else {
			if(review.getRatingValue()==0) {
				review.setRatingValue(5);
			}
			return ResponseEntity.ok(reviewService.save(review));
		}
	}
	
//	@Transactional
//	@PostMapping("/change-review")
//	public ResponseEntity<?> updateReview(@RequestBody Review review) {
//		User user = review.getUser();
//		ProductItem product = review.getProductItem();
//		reviewService.update(review.getComment(), review.getRatingValue(), user.getId(), product.getId());
//		return ResponseEntity.ok(new MessageResponse("Update your review successfully!"));
//	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<?> updateReview(@PathVariable("id") Integer id, @RequestBody Review review) {		
		return ResponseEntity.ok(reviewService.update(review.getComment(), review.getRatingValue(), id));
	}
}
