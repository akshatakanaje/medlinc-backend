package com.simplilearn.medlinc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medlinc.entity.Medicines;
import com.simplilearn.medlinc.repository.MedicinesRepository;
import com.simplilearn.medlinc.service.MedicinesService;

@Service
public class MedicinesServiceImp implements MedicinesService {
	
	@Autowired
	MedicinesRepository medicinesRepository;

	@Override
	public List<Medicines> findAll() {
		return medicinesRepository.findAll();
	}


	@Override
	public Optional<Medicines> findById(int medicineId) {
		return medicinesRepository.findById(medicineId);
	}

	@Override
	public boolean existsById(int medicineId) {
		return medicinesRepository.existsById(medicineId);
	}

	@Override
	public Medicines save(Medicines medicines) {
		return medicinesRepository.save(medicines);
	}

	@Override
	public void deleteById(int medicineId) {
		medicinesRepository.deleteById(medicineId);
		
	}


	@Override
	public List<Medicines> getAll() {
	
		return getAll();
	}


	

}
