package com.ds.quickOrder.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.Constants;
import com.ds.quickOrder.controller.CartController;
import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.model.SaleItemRowMapper;
import com.ds.quickOrder.service.HelperServiceImpl;

@Transactional
@Repository
public class SaleItemDaoImpl implements SaleItemDao{
	@Autowired
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	HelperServiceImpl helper;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SaleItem> getAllSaleItems() {
		String query = "select * from sale_item";
		
		RowMapper<SaleItem> rowMapper = new SaleItemRowMapper();
		List<SaleItem> list = jdbcTemplate.query(query, rowMapper);
		  
		  return list;
	}
	
	@Override
	public SaleItem findSaleItemById(int id) {
		String query = "select * from sale_item where id = " + id;
		RowMapper<SaleItem> rowMapper = new SaleItemRowMapper();
		SaleItem item = jdbcTemplate.queryForObject(query, rowMapper);
	
		return item;
	}

	
	//any more refactoring with the strings????
	@Override
	public List<SaleItem> searchSaleItemByName(String name) {
		StringBuilder nameBuilder = new StringBuilder(name);
		log.info("Entering searchSaleItemByName");
		String query = "select * from sale_item where name like " + "'%" +  nameBuilder + "%'";
		log.info(Constants.QUERY_HEADER + query);
		RowMapper<SaleItem> rowMapper = new SaleItemRowMapper();
		List<SaleItem> result = new ArrayList<SaleItem>();
		result = jdbcTemplate.query(query ,rowMapper);
		
		int limitCounter = Constants.QUERY_SEARCH_LIMIT;
		while(result.size() < 1 & nameBuilder.length() >=1 & limitCounter > 0) {
			nameBuilder.deleteCharAt(nameBuilder.length()-1);
			query = "select * from sale_item where name like " + "'%" +  nameBuilder + "%'";
			log.info(Constants.QUERY_HEADER + query);
			result = jdbcTemplate.query(query.toString(), rowMapper);
			limitCounter--;
		}
		log.info("Query Result Size is " + result.size());
		return result;
	}
	
	@Override
	public SaleItem findSaleItemByName(String name) {
		String query = "select * from sale_item where name = '" + name + "'";
		SaleItemRowMapper mapper = new SaleItemRowMapper();
		
		SaleItem item = jdbcTemplate.queryForObject(query, mapper);
		
		
		return item;
	}

	@Override
	public List<SaleItem> searchSaleItemByCategory(Category category) {
		String query = "select * from sale_item where category = " + category.getId();
		RowMapper<SaleItem> rowMapper = new SaleItemRowMapper();

		List<SaleItem> result = jdbcTemplate.query(query, rowMapper);
		
		return result;
	}
}