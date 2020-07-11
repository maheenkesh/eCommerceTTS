package com.tts.eCommerceTTS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity 
public class Product {  
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "product_id") 
	
	private Long id;
	@NotBlank(message = "Product name cannot be blank") //what is being sold?
	private String name;
	
	@PositiveOrZero(message = "Product wholesale price cannot be negative") //but is zero really ok?
	private Double wholesalePrice;
	
	@PositiveOrZero(message = "Product retail price cannot be negative")
	private Double retailPrice;
	
	@NotBlank(message = "Product brand cannot be blank")
	private String brand;
	
	@NotBlank(message = "Product category cannot be blank")
	private String category;
	
	private String description;
	
	@PositiveOrZero(message = "Product inventory cannot be negative")
	private Integer inventory;
	private String image; //image attribute is a string representing the path where the image file is stored
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	public Product() {
		
	}
	
	@Override
	public int hashCode(){
	  final int temp = 14;
	  int ans = 1;
	  ans = (int)(temp * ans + id);
	  return ans;
	}

	@Override
	public boolean equals(Object obj){
	  if (this == obj) {
	    return true;
	  }
	  if (obj == null) {
	    return false;
	  }
	  if (this.getClass() != obj.getClass()) {
	    return false;
	  }
	  Product other = (Product)obj;
	  if (this.id != other.id) {
	    return false;
	  }
	  return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getWholesalePrice() {
		return wholesalePrice;
	}
	public void setWholesalePrice(Double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public Product(String name, Double wholesalePrice, Double retailPrice, String brand, String category,
			String description, Integer inventory, String image, Date createdAt, Date updatedAt) {
		this.name = name;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.inventory = inventory;
		this.image = image;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	} 
	
}
	