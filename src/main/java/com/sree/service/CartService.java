package com.sree.service;

import com.sree.exception.ProductException;
import com.sree.model.Cart;
import com.sree.model.CartItem;
import com.sree.model.User;
import com.sree.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public CartItem addCartItem(Long userId,AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
