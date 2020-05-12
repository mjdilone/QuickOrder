package com.ds.quickOrder.dao;

import java.util.List;

import com.ds.quickOrder.model.Category;

public interface CategoryDao {
	public List<Category> getAllCategories();
	public Category retrieveCategoryWithName(String name);
}
