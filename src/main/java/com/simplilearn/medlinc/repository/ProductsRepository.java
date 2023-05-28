package com.simplilearn.medlinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.medlinc.entity.Products;

public interface ProductsRepository  extends JpaRepository<Products, Integer>{

}
