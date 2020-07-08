package com.tts.eCommerceTTS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "user_id") 
	
	private Long id; 
	private String firstName; 
	private String lastName; 
	private String emailAddress; 
	private String address; 
	private Date createdAt;
	public User() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public User(String firstName, String lastName, String emailAddress, String address, Date createdAt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.address = address;
		this.createdAt = createdAt;
	}  
	
	
}