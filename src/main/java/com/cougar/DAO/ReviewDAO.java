package com.cougar.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cougar.entity.Review;

public interface ReviewDAO extends JpaRepository<Review, Integer>{

}
