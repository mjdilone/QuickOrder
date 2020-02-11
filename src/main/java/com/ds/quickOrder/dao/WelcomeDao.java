package com.ds.quickOrder.dao;

import java.util.List;

import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.Company;

public interface WelcomeDao {
	public Company retrieveCompany();
	public List<Category> getAllCategories();
	public Category retrieveCategory(String name);
	
}
