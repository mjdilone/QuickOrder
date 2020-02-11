package com.ds.quickOrder.model;

public class Company {
	private String name;
	private String description;
	
	public Company() {
		
	}
	public Company(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", description=" + description + "]";
	}
	
}
