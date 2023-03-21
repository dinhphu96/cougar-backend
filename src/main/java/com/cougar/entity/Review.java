package com.cougar.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "Reviews")
@Data
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "product_item_id")
	ProductItem productItem;

	Integer ratingValue;

	String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date createDate = new Date();

	@Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user.fullname +
                ", productItem=" + productItem.id +
                ", ratingValue=" + ratingValue +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                '}';
    }

}
