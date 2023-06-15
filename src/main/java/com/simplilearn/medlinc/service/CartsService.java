package com.simplilearn.medlinc.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.medlinc.enduser.entity.Carts;


public interface CartsService {

	List<Carts> findByUserId(int parseInt);

	List<Carts> findAll();

	Optional<Carts> findById(int cartId);

	boolean existsById(int cartId);

	Carts save(Carts carts);

	void deleteById(int cartId);

}
