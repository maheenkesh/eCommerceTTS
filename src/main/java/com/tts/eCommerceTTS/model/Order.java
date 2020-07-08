package com.tts.eCommerceTTS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Order {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column (name = "order_id") 
	private Long id; 
	private String userName; 
	private Date orderedAt; 
	public Order() {
		// TODO Auto-generated constructor stub
	}
	private Double retailPrice;
	public Order(Long id, String userName, Date orderedAt, Double retailPrice) {
		this.id = id;
		this.userName = userName;
		this.orderedAt = orderedAt;
		this.retailPrice = retailPrice;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOrderedAt() {
		return orderedAt;
	}
	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public Long getId() {
		return id;
	} 
	
	
}
