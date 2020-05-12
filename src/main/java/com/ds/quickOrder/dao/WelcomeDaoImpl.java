package com.ds.quickOrder.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.Constants;
import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.CategoryRowMapper;
import com.ds.quickOrder.model.Company;
import com.ds.quickOrder.model.CompanyRowMapper;
import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.model.SaleItemRowMapper;

@Transactional
@Repository
public class WelcomeDaoImpl implements WelcomeDao{

	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CompanyDao companyDao;

	@Autowired
	CategoryDao categoryDao;
	
//	//JDBC
//	@Override
//	public Company retrieveCompany() {
//		CompanyRowMapper mapper = new CompanyRowMapper();
//		Company companyToRetrieve = jdbcTemplate.queryForObject("select * from company where name = '" + Constants.companyName + "'", mapper); 
//		
//		return companyToRetrieve;
//	}

	
	//Hibernate
	@Override
	public Company retrieveCompany() {
		Company company = null;
		try {
			company = companyDao.findCompany(Constants.testCompanyName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return company;
	}
	
//	//JDBC
//	@Override
//	public List<Category> getAllCategories() {
//		String query = "select * from categories";
//		CategoryRowMapper mapper = new CategoryRowMapper();
//		List<Category> list = jdbcTemplate.query(query,mapper);
//		
//		
//		return list;
//	}
//
	
	//Hibernate
	@Override
	public List<Category> getAllCategories() {		
		return categoryDao.getAllCategories();
	}

	
//	//JDBC
//	public Category retrieveCategory(String categoryName) {
//		CategoryRowMapper mapper = new CategoryRowMapper();
//		Category category = jdbcTemplate.queryForObject("select * from categories where name = '" + categoryName +  "'", mapper); 
//		
//		return category;
//	}

	
	//Hibernate
	public Category retrieveCategory(String categoryName) {
		Category category = null;
		try {
			category = categoryDao.retrieveCategoryWithName(categoryName);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return category;
	}
	
	//util
	@Override
	public void saveVisitorAddress(String address) {
		//insert into tracker values (null,'test',now());
		String query = "insert into tracker " + 
				"values (null," + 
				"'" + 
				address + 
				"',now()" + 
		")";
		System.out.println(query);
		jdbcTemplate.execute(query);
	}
	
}