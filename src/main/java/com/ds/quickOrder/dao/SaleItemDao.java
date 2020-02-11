package com.ds.quickOrder.dao;

import java.util.List;

import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.SaleItem;

public interface SaleItemDao {
	public List<SaleItem> getAllSaleItems();
	public SaleItem findSaleItemById(int id);
	public List<SaleItem> searchSaleItemByName(String name);
	public SaleItem findSaleItemByName(String name);
	public List<SaleItem> searchSaleItemByCategory(Category category);
	
}
