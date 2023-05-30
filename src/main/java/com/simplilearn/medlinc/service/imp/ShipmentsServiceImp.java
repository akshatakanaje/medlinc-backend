package com.simplilearn.medlinc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medlinc.entity.Shipments;
import com.simplilearn.medlinc.repository.ShipmentsRepository;
import com.simplilearn.medlinc.service.ShipmentsService;

@Service
public class ShipmentsServiceImp implements ShipmentsService{

	@Autowired
	ShipmentsRepository shipmentsRepository;

	@Override
	public List<Shipments> findByShipmentStatusContaining(String status) {
		return  shipmentsRepository.findByShipmentStatusContaining(status);
	}

	@Override
	public List<Shipments> findAll() {
		return  shipmentsRepository.findAll();
	}

	@Override
	public Optional<Shipments> findById(int shipmentId) {
		return  shipmentsRepository.findById(shipmentId);
	}

	@Override
	public boolean existsByShipmentStatus(int shipmentStatus) {
		return  shipmentsRepository.existsByShipmentStatus(shipmentStatus);
	}

	@Override
	public Shipments save(Shipments shipments) {
		return  shipmentsRepository.save(shipments);
	}

	@Override
	public boolean existsById(int shipmentId) {
		return  shipmentsRepository.existsById(shipmentId);
	}

	@Override
	public void deleteById(int shipmentId) {
		 shipmentsRepository.deleteById(shipmentId);
		
	}
	
	
}
