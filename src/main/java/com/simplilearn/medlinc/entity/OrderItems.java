package com.simplilearn.medlinc.entity;

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
@Table(name = "orderitems")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderItemId")
	private int orderItemId;
	
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="medicineId")
	private int medicineId;
	
	@Column(name="medicineName")
	private String medicineName;
	
	@Column(name="price")
	private int price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="totalPrice")
	private int totalPrice;

}
