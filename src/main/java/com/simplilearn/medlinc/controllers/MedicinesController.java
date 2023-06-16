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
import org.springframework.web.bind.annotation.RestController;
import com.simplilearn.medlinc.dto.ResponseDto;
import com.simplilearn.medlinc.entity.Medicines;
import com.simplilearn.medlinc.exceptions.AlreadyExistsException;
import com.simplilearn.medlinc.exceptions.NotFoundException;
import com.simplilearn.medlinc.service.MedicinesService;

@RequestMapping
@RestController("/medicines")
public class MedicinesController {
	
	@Autowired
	MedicinesService medicinesService;
	


	@GetMapping()
	public List<Medicines> getAllMedicines() {
		return medicinesService.getAll();

	}
	

	@GetMapping("/{medicineId}")
	public Optional<Medicines> getOne(@PathVariable("medicineId") int medicineId){
		Optional<Medicines> medicineData = medicinesService.findById(medicineId);
		if(medicineData.isPresent()) {
			return medicineData;
		}
		throw new NotFoundException("medicine does not exist with id '"+ medicineId +"'");
	}
	
	
	@PostMapping
	public Medicines save(@RequestBody Medicines medicines) {
		boolean exists = medicinesService.existsById(medicines.getMedicineId());
		if(!exists) {
			return  medicinesService.save(medicines);
		}
		throw new AlreadyExistsException("medicine is already exist with id'"+ medicines.getMedicineId() +"'");
	}
	
	@PutMapping
	public Medicines update(@RequestBody Medicines medicines) {
		boolean exists = medicinesService.existsById(medicines.getMedicineId());
		if(exists) {
			return medicinesService.save(medicines);
		}
		throw new NotFoundException("Medicine does not exist with medicineId '"+ medicines.getMedicineId() +"'");
	}
	
	@DeleteMapping("/{medicineId}")
	public ResponseDto deleteOne(@PathVariable("medicineId") int medicineId) {
		boolean exists = medicinesService.existsById(medicineId);
		if (exists) {
			medicinesService.deleteById(medicineId);
			return new ResponseDto("Success","Medicine is  deleted", new Date(), null);
		}
		throw new NotFoundException("Medicine does not exist with medicineId '"+ medicineId +"'");
	}
	

}
