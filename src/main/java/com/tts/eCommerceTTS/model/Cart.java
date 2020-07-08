package com.tts.eCommerceTTS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import java.util.HashMap; 
import java.util.List; 

@Entity
public class Cart {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	
	private List<HashMap<Product, Integer>> lineItems;
	private Double subTotal;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public List<HashMap<Product, Integer>> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<HashMap<Product, Integer>> lineItems) {
		this.lineItems = lineItems;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Cart(List<HashMap<Product, Integer>> lineItems, Double subTotal) {
		this.lineItems = lineItems;
		this.subTotal = subTotal;
	}
}
