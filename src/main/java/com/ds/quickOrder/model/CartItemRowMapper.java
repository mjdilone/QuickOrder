package com.ds.quickOrder.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ds.quickOrder.service.SaleItemService;

public class CartItemRowMapper implements RowMapper<CartItem>{
	//@Autowired
	SaleItemService saleItemService2;
	
	@Override
	public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CartItem cartItem = new CartItem();
		
		cartItem.setCustomerId(rs.getLong("customer_id"));
		cartItem.setName(rs.getString("item_name"));
		cartItem.setQuantity(rs.getInt("quantity"));
		
		return cartItem;
	}

}
