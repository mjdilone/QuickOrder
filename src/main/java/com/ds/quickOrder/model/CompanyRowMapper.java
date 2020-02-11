package com.ds.quickOrder.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CompanyRowMapper implements RowMapper<Company> {

	@Override
	public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Company company = new Company();
		
		company.setName(rs.getString("name"));
		company.setDescription(rs.getString("description"));
		
		return company;
	}

	
}
