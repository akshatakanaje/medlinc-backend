package com.simplilearn.medlinc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medlinc.entity.Orders;
import com.simplilearn.medlinc.repository.OrdersRepository;
import com.simplilearn.medlinc.service.OrdersService;

@Service
public class OrdersServiceImp implements OrdersService{

	@Autowired
	OrdersRepository ordersRepository;
	
	@Override
	public List<Orders> findByOrderStatusContaining(String status) {
		return  ordersRepository.findByOrderStatusContaining(status);
	}

	@Override
	public List<Orders> findByAll() {
		return  ordersRepository.findAll();
	}

	@Override
	public Optional<Orders> findById(int orderId) {
		return  ordersRepository.findById(orderId);
	}

	@Override
	public boolean existsByOrderStatus(String orderStatus) {
		return  ordersRepository.existsByOrderStatus(orderStatus);
	}

	@Override
	public Orders save(Orders orders) {
		return  ordersRepository.save(orders);
	}

	@Override
	public boolean existsById(int orderId) {
		return  ordersRepository.existsById(orderId);
	}

	@Override
	public void deleteById(int orderId) {
		 ordersRepository.deleteById(orderId);
		
	}

}
