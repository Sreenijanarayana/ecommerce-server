package com.sree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sree.model.OrderItem;



public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
