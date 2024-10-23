package com.sree.service;


import java.util.List;

import com.sree.exception.ProductException;
import com.sree.model.Rating;
import com.sree.model.User;
import com.sree.request.RatingRequest;



public interface RatingServices {
	
	public Rating createRating(RatingRequest req,User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}
