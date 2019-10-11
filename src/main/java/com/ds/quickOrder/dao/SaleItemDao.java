package com.ds.quickOrder.dao;

import java.util.List;

import com.ds.quickOrder.model.SaleItem;

public interface SaleItemDao {
	
	public List<SaleItem> getAllSaleItems();
	
	public SaleItem findSaleItemById(int id);
	
	public SaleItem findSaleItemByName(String name);
	
	
	
}
