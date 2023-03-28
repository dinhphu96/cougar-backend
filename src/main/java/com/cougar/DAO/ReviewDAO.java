package com.cougar.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//import com.cougar.entity.ProductItem;
import com.cougar.entity.Review;


public interface ReviewDAO extends JpaRepository<Review, Integer> {
	@Query("SELECT r FROM Review r WHERE r.productItem.id = ?1 ORDER BY r.createDate DESC")
	List<Review> getListReviewByProductItemId(Integer productItem);
	
	@Query(value = "SELECT * FROM Reviews r WHERE r.user_id = ?1 and r.product_item_id = ?2 ", nativeQuery = true)
	Review findByUserAndProductItem(Integer user, Integer productItem);
	
	@Query(value = "SELECT * FROM Reviews r WHERE r.id = ?1", nativeQuery = true)
	Review findByIdReview(Integer id);
	
	@Modifying
	@Query("UPDATE Review r SET r.comment = ?1, r.ratingValue = ?2, r.createDate = ?3, r.edited = true WHERE r.id = ?4")
	void updateById(String comment, Integer ratingValue, Date newTime, Integer reviewId);
	
}
