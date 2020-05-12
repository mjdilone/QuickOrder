package com.ds.quickOrder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ds.quickOrder.Constants;

@Entity
@Table(name = Constants.TABLE_NAME_CATEGORIES)
public class CategoryEntity extends Category{
	@Id
	private int id;
	@Column(name = "name")
	private String name;
	
	
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
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
