package com.simplilearn.medlinc.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.medlinc.entity.Products;

public interface ProductsService {

	List<Products> findByProductTitleContaining(String title);

	List<Products> findAll();

	Optional<Products> findById(int productId);

	boolean existsByProductTitle(String productTitle);

	Products save(Products products);

	boolean existsById(int productId);

	void deleteById(int productId);

	

}
