package com.simplilearn.medlinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.medlinc.entity.OrderItems;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>{

}
