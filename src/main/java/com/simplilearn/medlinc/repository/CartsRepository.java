package com.simplilearn.medlinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.medlinc.enduser.entity.Carts;

@Repository
public interface CartsRepository extends JpaRepository<Carts, Integer>{

	List<Carts> findByUserId(int userId);

}
