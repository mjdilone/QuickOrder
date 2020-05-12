package com.ds.quickOrder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ds.quickOrder.Constants;

@Entity
@Table(name = Constants.TABLE_NAME_COMPANY)
public class CompanyEntity extends Company{
	
	@Id
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	
	public CompanyEntity() {
		
	}
	
	public CompanyEntity(String name, String description) {
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