package com.ds.quickOrder.service;

import java.util.List;

import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.Company;
import com.ds.quickOrder.model.SaleItem;

public interface WelcomeService {
	public Company retrieveCompany();
	public List<Category> getAllCategories();
	public Category retrieveCategory(String category);
	public List<SaleItem> searchSaleItemByCategory(Category category);
	
}
