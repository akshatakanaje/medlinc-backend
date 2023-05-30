package com.simplilearn.medlinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.medlinc.entity.Orders;

@Repository
public interface OrdersRepository  extends JpaRepository<Orders, Integer>{

	List<Orders> findByOrderStatusContaining(String status);

	boolean existsByOrderStatus(String orderStatus);

}
