package com.simplilearn.medlinc.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.medlinc.entity.Orders;

public interface OrdersService {

	List<Orders> findByOrderStatusContaining(String status);

	List<Orders> findByAll();

	Optional<Orders> findById(int orderId);

	boolean existsByOrderStatus(String orderStatus);

	Orders save(Orders orders);

	boolean existsById(int orderId);

	void deleteById(int orderId);

}
