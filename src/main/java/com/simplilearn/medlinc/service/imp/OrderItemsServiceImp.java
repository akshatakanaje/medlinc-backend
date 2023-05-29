package com.simplilearn.medlinc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medlinc.entity.OrderItems;
import com.simplilearn.medlinc.repository.OrderItemsRepository;
import com.simplilearn.medlinc.service.OrderItemsService;

@Service
public class OrderItemsServiceImp implements OrderItemsService{
	
	@Autowired 
	OrderItemsRepository orderItemsRepository;

	@Override
	public List<OrderItems> findByProductTitleContaining(String title) {
		return orderItemsRepository.findByProductTitleContaining(title);
	}

	@Override
	public List<OrderItems> findAll() {
		return orderItemsRepository.findAll();
	}

	@Override
	public Optional<OrderItems> findById(int orderItemId) {
		return orderItemsRepository.findById(orderItemId);
	}

	@Override
	public boolean existsById(int orderItemId) {
		return orderItemsRepository.existsById(orderItemId);
	}

	@Override
	public OrderItems save(OrderItems orderItems) {
		return orderItemsRepository.save(orderItems);
	}

	@Override
	public void deleteById(int orderItemId) {
		orderItemsRepository.deleteById(orderItemId);
		
	}

}
