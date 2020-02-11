package com.ds.quickOrder.model;

public class CartItem {
	@Override
	public String toString() {
		return "CartItem [name=" + name + ", quantity=" + quantity + ", customerId=" + customerId + ", imageSource="
				+ imageSource + ", id=" + id + "]";
	}
	private String name;
	private int quantity;
	private long customerId;
	private String imageSource; 
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public String getImageSource() {
		return imageSource;
	}
	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}

}
