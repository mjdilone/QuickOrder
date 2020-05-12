package com.ds.quickOrder.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.CategoryEntity;
import com.ds.quickOrder.repo.CategoryRepo;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	CategoryRepo repo;
	
	@Override
	public List<Category> getAllCategories() {
		List<CategoryEntity> list = repo.findAll();
		ArrayList<Category> result = new ArrayList<Category>(list);
		return result;
	}

	@Override
	public Category retrieveCategoryWithName(String name) {
		Category category = repo.findByName(name);
		return category;
	}
	

}
