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
	
	@Override
	public Company retrieveCompany() {
		CompanyRowMapper mapper = new CompanyRowMapper();
		Company companyToRetrieve = jdbcTemplate.queryForObject("select * from company where name = '" + Constants.companyName + "'", mapper); 
		
		return companyToRetrieve;
	}


	@Override
	public List<Category> getAllCategories() {
		String query = "select * from categories";
		CategoryRowMapper mapper = new CategoryRowMapper();
		List<Category> list = jdbcTemplate.query(query,mapper);
		
		return list;
	}


	public Category retrieveCategory(String categoryName) {
		CategoryRowMapper mapper = new CategoryRowMapper();
		Category category = jdbcTemplate.queryForObject("select * from categories where name = '" + categoryName +  "'", mapper); 
		
		return category;
	}


	@Override
	public void saveVisitorAddress(String address) {
		String query = "insert into tracker " + "values (null," + "'" + address + "'" + ")";
		System.out.println(query);
		jdbcTemplate.execute(query);
	}
	
}