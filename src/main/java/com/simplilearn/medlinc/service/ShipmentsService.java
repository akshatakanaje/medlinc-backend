package com.simplilearn.medlinc.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.medlinc.entity.Shipments;

public interface ShipmentsService {

	List<Shipments> findByShipmentStatusContaining(String status);

	List<Shipments> findAll();

	Optional<Shipments> findById(int shipmentId);

	boolean existsByShipmentStatus(int shipmentStatus);

	Shipments save(Shipments shipments);

	boolean existsById(int shipmentId);

	void deleteById(int shipmentId);

}
