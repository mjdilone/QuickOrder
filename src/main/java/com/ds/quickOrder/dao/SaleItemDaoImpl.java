package com.ds.quickOrder.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.model.SaleItemRowMapper;

@Transactional
@Repository
public class SaleItemDaoImpl implements SaleItemDao{

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

	@Override
	public SaleItem findSaleItemByName(String name) {
		String query = "select * from sale_item where name = " + "'" +  name + "'";
		System.out.println(query);
		RowMapper<SaleItem> rowMapper = new SaleItemRowMapper();
		SaleItem item = jdbcTemplate.queryForObject(query, rowMapper);
	
		return item;
	}
	
}
