package com.simplilearn.medlinc.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.medlinc.dto.ResponseDto;
import com.simplilearn.medlinc.entity.Shipments;
import com.simplilearn.medlinc.exceptions.AlreadyExistsException;
import com.simplilearn.medlinc.exceptions.NotFoundException;
import com.simplilearn.medlinc.service.ShipmentsService;

@RestController
@RequestMapping("/shipments")
public class ShipmentsController {
	
	@Autowired
	ShipmentsService shipmentsService;
	
	/**
	 * Get all Shipments or Search Shipments by title like operation.
	 * @param title
	 * @return
	 */
	@GetMapping
	public List<Shipments> getAll(@RequestParam(value="status", required =false) String status){
		if(status != null && status != "") {
			return shipmentsService.findByShipmentStatusContaining(status);
		}
		return shipmentsService.findAll();
	}
	
	/**
	 * Get one order by id
	 * @param orderId
	 * @return
	 */
	@GetMapping("/{shipmentId}")
	public Optional<Shipments> getOne(@PathVariable("shipmentId") int shipmentId){
		 Optional<Shipments> shipmentData = shipmentsService.findById(shipmentId);
		 if(shipmentData.isPresent()) {
			 return shipmentData;
		 }
		 throw new NotFoundException("Shipment data does not exist with shipmentId '"+ shipmentId +"'");
	}
	
	/**
	 * Save shipment.
	 * @param shipment
	 * @return
	 */
	@PostMapping
	public Shipments save(@RequestBody Shipments shipments) {
		boolean exists = shipmentsService.existsByShipmentStatus(shipments.getShipmentStatus());
		if(!exists) {
			return shipmentsService.save(shipments);
		}
		throw new AlreadyExistsException("Shipments already exist with status '"+ shipments.getShipmentStatus() +"'");
	}
	
	
	/**
	 * Update shipment
	 * @param  shipment
	 * @return
	 */
	@PutMapping
	public Shipments update(@RequestBody Shipments shipments) {
		boolean exists = shipmentsService.existsById(shipments.getShipmentId());
		if(exists) {
			return shipmentsService.save(shipments);
		}
		throw new NotFoundException("Shipments does not exist with shipmentId '"+ shipments.getShipmentId() +"'");
	}
	
	/**
	 * Delete one shipment by id
	 * @param shipmentId
	 * @return Optional<Products>
	 */
	@DeleteMapping("/{shipmentId}")
	public ResponseDto deleteOne(@PathVariable("shipmentId") int shipmentId) {
		boolean exists = shipmentsService.existsById(shipmentId);
		if(!exists) {
			shipmentsService.deleteById(shipmentId);
			return new ResponseDto("Success","Shipment data deleted", new Date(), null);
		}
		throw new NotFoundException("Shipment does not exist with shipmentId '"+ shipmentId +"'");			
	}
}


