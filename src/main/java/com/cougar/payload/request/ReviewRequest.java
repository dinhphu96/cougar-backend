package com.cougar.payload.request;

import lombok.Data;

@Data
public class ReviewRequest {
	private String email;
    private Integer productId;
    private String comment;
    private Float rating;
}
