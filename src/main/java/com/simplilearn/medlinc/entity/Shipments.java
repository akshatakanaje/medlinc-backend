package com.simplilearn.medlinc.entity;

import java.util.Date;

public class Shipments {
	
	private int shipmentId;
	private int  orderId;
	private int shipmentStatus;
	private String  shipmentTitle;
	private Date shipmentDate = new Date();
	private Date  expectedDeliveryDate;
	private String  shipmentMethod ;
	private String shipmentCompany;

}
