package com.simplilearn.medlinc.entity;

import java.util.Date;
import java.util.List;

public class Products {
	
	private int productId;
	private String productTitle;
	private String productDescription;
	private String productCode;
	private List<String> images;
	private int thumbnailImage;
	private double price;
	private Date addedOn = new Date();
	private double rating;

}
