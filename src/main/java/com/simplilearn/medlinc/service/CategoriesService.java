package com.simplilearn.medlinc.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.medlinc.entity.Categories;

public interface CategoriesService {

	List<Categories> findByCategoryNameContaining(String title);

	List<Categories> findAll();

	Optional<Categories> findById(int id);

	boolean existsByCategoryName(String categoryName);

	boolean existsById(int categoryId);

	Categories save(Categories categories);

	void deleteById(int id);

}
