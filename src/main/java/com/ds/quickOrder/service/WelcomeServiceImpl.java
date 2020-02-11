package com.ds.quickOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.quickOrder.dao.WelcomeDaoImpl;
import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.Company;
import com.ds.quickOrder.model.SaleItem;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Autowired
	WelcomeDaoImpl welcomeDao;
	
	@Autowired 
	SaleItemServiceImpl saleItemService;
	
	@Override
	public Company retrieveCompany() {
		Company company = null;
		
		try {
			company = welcomeDao.retrieveCompany();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return company;
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> result = null;
		
		try {
			result = welcomeDao.getAllCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Category retrieveCategory(String category) {
		Category categoryToSearch = null;
		
		try {
			categoryToSearch =  welcomeDao.retrieveCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categoryToSearch;
	}

	@Override
	public List<SaleItem> searchSaleItemByCategory(Category category) {
		
		List<SaleItem> result = null;
		try {
			result = saleItemService.searchSaleItemByCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
