package com.ds.quickOrder.service;

import java.util.List;

import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.SaleItem;

public interface SaleItemService {
	 public List<SaleItem> getAllSaleItems();
	 public SaleItem findSaleItemById(int id);
	 public SaleItem findSaleItemByName(String name);
	 public List<SaleItem> searchSaleItemByName(String name);
	 public List<SaleItem> searchSaleItemByCategory(Category category);
	 int retrieveCartCount(String userId,Boolean isGuest);

}
