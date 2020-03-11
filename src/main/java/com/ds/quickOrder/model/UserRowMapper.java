package com.ds.quickOrder.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setFname(rs.getString("first_name"));
		user.setLname(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setUname(rs.getString("username"));
		
		return user;
	}
	
}
