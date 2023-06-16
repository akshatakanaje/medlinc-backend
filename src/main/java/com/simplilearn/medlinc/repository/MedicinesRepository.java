package com.simplilearn.medlinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.simplilearn.medlinc.entity.Medicines;

@Repository
public interface MedicinesRepository extends JpaRepository<Medicines, Integer>{



	List<Medicines> fetchMedicineList();

	

	

}
