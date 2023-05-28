package com.simplilearn.medlinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.medlinc.entity.Orders;

@Repository
public interface OrdersRepository  extends JpaRepository<Orders, Integer>{

}
