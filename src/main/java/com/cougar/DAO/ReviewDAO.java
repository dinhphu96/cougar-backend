package com.cougar.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//import com.cougar.entity.ProductItem;
import com.cougar.entity.Review;


public interface ReviewDAO extends JpaRepository<Review, Integer> {
	@Query(value = "SELECT * FROM Reviews r WHERE r.product_item_id = ?1 ORDER BY r.id DESC", nativeQuery = true)
	List<Review> getListReviewByProductItemId(Integer productItem);
	
	@Query(value = "SELECT * FROM Reviews r WHERE r.user_id = ?1 and r.product_item_id = ?2 ", nativeQuery = true)
	Review findByUserAndProductItem(Integer user, Integer productItem);
	
	@Modifying
	@Query("UPDATE Review r SET r.comment = ?1, r.ratingValue = ?2, r.createDate = ?3 WHERE r.user.id = ?4 and r.productItem.id = ?5")
	void updateById(String comment, Integer ratingValue, Date newTime, Integer userId, Integer productId);
	
//	@Query(value = "SELECT * FROM Reviews r WHERE  r.user_id = ?1 and r.product_item_id = ?2 ", nativeQuery = true)
//	Review findByUserIdAndProductId(Integer userId, Integer productId);
}
