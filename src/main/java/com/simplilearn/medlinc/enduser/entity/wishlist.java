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
@Table(name = "Wishlist")
public class wishlist {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="wishListId")
		private int wishListId;    
		
		@Column(name="medicineId")
		private int medicineId;
		
		@Column(name="userId")
		private int userId;

}
