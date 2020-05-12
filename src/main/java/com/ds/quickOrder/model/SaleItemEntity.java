package com.ds.quickOrder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ds.quickOrder.Constants;

@Entity
@Table(name = Constants.TABLE_NAME_SALE_ITEMS)
public class SaleItemEntity extends SaleItem{
	
	@Id
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "price_per_unit")
	private double pricePerUnit;
	@Column(name = "srp")
	private double srp;
	@Column(name = "image_path")
	private String imageSource;
	@Column(name = "description")
	private String itemDescription;
	@Column(name = "category")
	private int category;
	
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
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public double getSrp() {
		return srp;
	}
	public void setSrp(double srp) {
		this.srp = srp;
	}
	public String getImageSource() {
		return imageSource;
	}
	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "SaleItem [id=" + id + ", name=" + name + ", pricePerUnit=" + pricePerUnit + ", srp=" + srp
				+ ", imageSource=" + imageSource + ", itemDescription=" + itemDescription + ", category=" + category
				+ "]";
	}
}
