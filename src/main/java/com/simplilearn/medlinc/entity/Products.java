package com.simplilearn.medlinc.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Products {
	
	   //products model attributes
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="productId")
		private int productId;
		
		@Column(name="productTitle")
		private String productTitle;
		
		@Column(name="productDescription")
		private String productDescription;
		
		@Column(name="productCode")
		private String productCode;
		
		@ElementCollection
		@CollectionTable(name="images", joinColumns = @JoinColumn(name="id"))
		@Column(name="list")
		private List<String> images;
		
		@Column(name="thumbnailImage")
		private int thumbnailImage;
		
		@Column(name="price")
		private double price;
		
		@Column(name="addedOn")
		private Date addedOn = new Date();
		
		@Column(name="rating")
		private double rating;

}
