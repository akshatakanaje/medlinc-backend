package com.simplilearn.medlinc.entity;

import java.util.Date;

public class Orders {
	
	private int orderId;
	private Date orderDate = new Date();
	private String orderStatus;
	private int totalItems;
	private int itemsSubTotal;
	private int shipmentCharges;
	private int totalAmount;
	private String paymentStatusTitle;
	private int paymentMethod;
	private String paymentMethodTitle;
	private int paymentStatus;
	private int userId;
	private String email;
	private String address;
	private String name;
	private Long contact;

}
