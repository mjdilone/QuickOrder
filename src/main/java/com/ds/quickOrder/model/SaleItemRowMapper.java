package com.ds.quickOrder.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SaleItemRowMapper implements RowMapper<SaleItem> {

 @Override
 public SaleItem mapRow(ResultSet resultSet, int rowNum) throws SQLException {

	 SaleItem item = new SaleItem();
	 item.setId(resultSet.getInt("id"));
	 item.setName(resultSet.getString("name"));
	 item.setPricePerUnit(resultSet.getDouble("price_per_unit"));
	 item.setSrp(resultSet.getDouble("srp"));
	 item.setImageSource(resultSet.getString("image_path"));
	 item.setItemDescription(resultSet.getString("description"));
	 item.setCategory(resultSet.getInt("category"));
	 
	 return item;
	
 }

}