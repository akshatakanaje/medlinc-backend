package com.simplilearn.medlinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.medlinc.entity.Shipments;

public interface ShipmentsRepository extends JpaRepository<Shipments, Integer>{

}
