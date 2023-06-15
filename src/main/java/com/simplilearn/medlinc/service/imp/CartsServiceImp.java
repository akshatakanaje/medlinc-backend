package com.simplilearn.medlinc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medlinc.enduser.entity.Carts;
import com.simplilearn.medlinc.repository.CartsRepository;
import com.simplilearn.medlinc.service.CartsService;

@Service
public class CartsServiceImp implements CartsService{

	@Autowired
	CartsRepository cartsRepository;
	
	@Override
	public List<Carts> findByUserId(int userId) {
		return cartsRepository.findByUserId(userId);
	}

	@Override
	public List<Carts> findAll() {
		return cartsRepository.findAll();
	}

	@Override
	public Optional<Carts> findById(int cartId) {
		return cartsRepository.findById(cartId);
	}

	@Override
	public boolean existsById(int cartId) {
		return cartsRepository.existsById(cartId);
	}

	@Override
	public Carts save(Carts carts) {
		return cartsRepository.save(carts);
	}

	@Override
	public void deleteById(int cartId) {
		cartsRepository.deleteById(cartId);		
	}

}
