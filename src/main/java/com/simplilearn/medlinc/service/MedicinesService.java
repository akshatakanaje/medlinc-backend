package com.simplilearn.medlinc.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.medlinc.entity.Medicines;

public interface MedicinesService {

	List<Medicines> findAll();

	Optional<Medicines> findById(int medicineId);

	boolean existsById(int medicineId);

	Medicines save(Medicines medicines);

	void deleteById(int medicineId);


	List<Medicines> getAll();

	

	
}
