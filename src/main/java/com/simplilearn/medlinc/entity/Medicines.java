package com.simplilearn.medlinc.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="medicines")
public class Medicines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medicineId")
	private int medicineId;
	
	@Column(name="medicineName")
	private String medicineName;
	
	@Column(name="brandName")
	private String brandName;
	
	@Column(name="measurementUnit")
	private String measurementUnit;
	
	@Column(name="form")
	private String form;
	
	@Column(name="addedOn")
	private Date addedOn = new Date();
	
}
