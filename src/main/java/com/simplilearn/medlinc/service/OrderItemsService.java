package com.simplilearn.medlinc.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.medlinc.entity.OrderItems;

public interface OrderItemsService {

	

	List<OrderItems> findAll();

	Optional<OrderItems> findById(int orderItemId);

	boolean existsById(int orderItemId);

	OrderItems save(OrderItems orderItems);

	void deleteById(int orderItemId);

	List<OrderItems> findById(String medicineId);

}
