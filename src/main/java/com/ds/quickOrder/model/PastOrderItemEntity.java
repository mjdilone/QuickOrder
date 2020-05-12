package com.ds.quickOrder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ds.quickOrder.Constants;

@Entity
@Table(name = Constants.TABLE_NAME_PASTORDERITEMS)
public class PastOrderItemEntity extends PastOrderItem{

	@Column(name="item_name")
	private String name;
	@Column(name="quantity")
	private int quantity;
	@Column(name = "customer_id")
	private long customerId;
	
	/*
	this entity originally didn't have a primary key for it's table, Hibernate however needs a primary key so an
	easy fix for that is adding a auto-incr id value to it's SQL table
	*/
	@Id
	private int specific_id; 
	
	public int getSpecific_id() {
		return specific_id;
	}

	public void setSpecific_id(int specific_id) {
		this.specific_id = specific_id;
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
	
	@Override
	public String toString() {
		return "PastOrderItemEntity [name=" + name + ", quantity=" + quantity + ", customerId=" + customerId + "]";
	}
	
	
}
