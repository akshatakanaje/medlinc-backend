package com.simplilearn.medlinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.medlinc.entity.Products;

public interface ProductsRepository  extends JpaRepository<Products, Integer>{

	List<Products> findByProductTitleContaining(String title);

	boolean existsByProductTitle(String productTitle);

}
