package com.simplilearn.medlinc.enduser.entity;

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
@Table(name = "carts")
public class Carts {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="cartId")
		private int cartId;
		
		@Column(name="medicineId")
		private int medicineId;
		
		@Column(name="userId")
		private int userId;
		
		@Column(name="quantity")
		private int quantity;

}
