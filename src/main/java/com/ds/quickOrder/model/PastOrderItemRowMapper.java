package com.ds.quickOrder.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PastOrderItemRowMapper implements RowMapper<PastOrderItem> {

	@Override
	public PastOrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		PastOrderItem pastOrderItem = new PastOrderItem();
		
		pastOrderItem.setCustomerId(rs.getLong("customer_id"));
		pastOrderItem.setName(rs.getString("item_name"));
		pastOrderItem.setQuantity(rs.getInt("quantity"));
		
		return pastOrderItem;
	}

}
