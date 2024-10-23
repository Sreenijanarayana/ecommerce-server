package com.sree.service;

import java.util.List;

import com.sree.exception.OrderException;
import com.sree.model.Address;
import com.sree.model.Order;
import com.sree.model.User;

//import com.zosh.exception.OrderException;
//import com.zosh.modal.Address;
//import com.zosh.modal.Order;
//import com.zosh.modal.User;

public interface OrderService {
	
	public Order createOrder(User user, Address shippingAdress);
	
	public Order findOrderById(Long orderId) throws OrderException;
	
	public List<Order> usersOrderHistory(Long userId);
	
	public Order placedOrder(Long orderId) throws OrderException;
	
	public Order confirmedOrder(Long orderId)throws OrderException;
	
	public Order shippedOrder(Long orderId) throws OrderException;
	
	public Order deliveredOrder(Long orderId) throws OrderException;
	
	public Order cancelledOrder(Long orderId) throws OrderException;
	
	public List<Order>getAllOrders();
	
	public void deleteOrder(Long orderId) throws OrderException;
	
}