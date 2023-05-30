package com.simplilearn.medlinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.medlinc.entity.Shipments;

public interface ShipmentsRepository extends JpaRepository<Shipments, Integer>{

	List<Shipments> findByShipmentStatusContaining(String status);

	boolean existsByShipmentStatus(int shipmentStatus);

}
