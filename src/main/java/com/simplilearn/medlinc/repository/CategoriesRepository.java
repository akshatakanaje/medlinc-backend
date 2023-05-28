package com.simplilearn.medlinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.medlinc.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{

}
