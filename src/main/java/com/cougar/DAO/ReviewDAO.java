package com.cougar.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.cougar.entity.ProductItem;
import com.cougar.entity.Review;

public interface ReviewDAO extends JpaRepository<Review, Integer> {
	@Query(value = "SELECT * FROM Reviews r WHERE r.product_item_id = ?1 ORDER BY r.id DESC", nativeQuery = true)
	List<Review> getListReviewByProductItemId(Integer productItem);
}
