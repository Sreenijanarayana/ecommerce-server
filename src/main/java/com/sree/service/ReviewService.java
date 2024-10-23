package com.sree.service;

import java.util.List;

import com.sree.exception.ProductException;
import com.sree.model.Review;
import com.sree.model.User;
import com.sree.request.ReviewRequest;



public interface ReviewService {

	public Review createReview(ReviewRequest req,User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
	
}
