package com.ds.quickOrder.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.Constants;
import com.ds.quickOrder.controller.CartController;
import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.model.SaleItemEntity;
import com.ds.quickOrder.repo.SaleItemRepo;
import com.ds.quickOrder.service.HelperServiceImpl;

@Transactional
@Repository
public class SaleItemDaoImpl implements SaleItemDao{
	
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	HelperServiceImpl helper;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SaleItemRepo repo;
	
	//JDBC
//	@Override
//	public List<SaleItem> getAllSaleItems() {
//		String query = "select * from sale_item";
//		
//		RowMapper<SaleItem> rowMapper = new SaleItemRowMapper();
//		List<SaleItem> list = jdbcTemplate.query(query, rowMapper);
//		  
//		  return list;
//	}
	
	//Hibernate
	@Override
	public List<SaleItem> getAllSaleItems() {
		List<SaleItem> listResult = new ArrayList<>(repo.findAll());
		return listResult;
	}
	
//	//JDBC
//	@Override
//	public SaleItem findSaleItemById(int id) {
//		String query = "select * from sale_item where id = " + id;
//		RowMapper<SaleItem> rowMapper = new SaleItemRowMapper();
//		SaleItem item = jdbcTemplate.queryForObject(query, rowMapper);
//	
//		return item;
//	}
//	

	
	//Hibernate
	@Override
	public SaleItem findSaleItemById(int id) {
		//since findById returns an Optional object we need to get it form the repo and then turn it into an entity
		//this helps in case it doesnt return anything it will return a common error that is easy to handle
		Optional<SaleItemEntity> itemOptional = repo.findById(id);
		SaleItemEntity item = itemOptional.get();
		return item;
	}

	
//	//TODO refactor the usage of strings
//	@Override
//	public List<SaleItem> searchSaleItemByName(String name) {
//		StringBuilder nameBuilder = new StringBuilder(name);
//		log.info("Entering searchSaleItemByName");
//		String query = "select * from sale_item where name like " + "'%" +  nameBuilder + "%'";
//		log.info(Constants.QUERY_HEADER + query);
//		
//		
//		
//		RowMapper<SaleItem> rowMapper = new SaleItemRowMapper();
//		List<SaleItem> result = new ArrayList<SaleItem>();
//		result = jdbcTemplate.query(query ,rowMapper);
//		
//		
//		
//		int limitCounter = Constants.QUERY_SEARCH_LIMIT;
//		while(result.size() < 1 & nameBuilder.length() >=1 & limitCounter > 0) {
//			nameBuilder.deleteCharAt(nameBuilder.length()-1);
//			query = "select * from sale_item where name like " + "'%" +  nameBuilder + "%'";
//			log.info(Constants.QUERY_HEADER + query);
//			result = jdbcTemplate.query(query.toString(), rowMapper);
//			limitCounter--;
//		}
//		log.info("Query Result Size is " + result.size());
//		return result;
//	}
	
	//hibernate
	//TODO refactor the usage of strings
	@Override
	public List<SaleItem> searchSaleItemByName(String name) {
		StringBuilder nameBuilder = new StringBuilder(name);
		log.info("Entering searchSaleItemByName with name: " + name);
		List<SaleItem> result = new ArrayList<SaleItem>();
		result = repo.searchWithName(name);
		
		int limitCounter = Constants.QUERY_SEARCH_LIMIT;
		while(result.size() < 1 & nameBuilder.length() >=1 & limitCounter > 0) {
			nameBuilder.deleteCharAt(nameBuilder.length()-1);
			result = repo.searchWithName(nameBuilder.toString());
			limitCounter--;
		}
		log.info("Query Result Size is " + result.size());
		return result;
	}
	
	
	
//	//JDBC
//	@Override
//	public SaleItem findSaleItemByName(String name) {
//		String query = "select * from sale_item where name = '" + name + "'";
//		SaleItemRowMapper mapper = new SaleItemRowMapper();
//		
//		SaleItem item = jdbcTemplate.queryForObject(query, mapper);
//		
//		
//		return item;
//	}

	
//	//Hibernate
	@Override
	public SaleItem findSaleItemByName(String name) {
		SaleItem item = repo.findByName(name);
		return item;
	}
	
//	//JDBC
//	@Override
//	public List<SaleItem> searchSaleItemByCategory(Category category) {
//		String query = "select * from sale_item where category = " + category.getId();
//		RowMapper<SaleItem> rowMapper = new SaleItemRowMapper();
//
//		List<SaleItem> result = jdbcTemplate.query(query, rowMapper);
//		
//		return result;
//	}
	
	//Hibernate
	@Override
	public List<SaleItem> searchSaleItemByCategory(Category category) {
		List<SaleItem> result = repo.findByCategory(category.getId());
		return result;
	}
}