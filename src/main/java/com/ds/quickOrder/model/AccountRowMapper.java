package com.ds.quickOrder.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		
		account.setId(rs.getInt("id"));
		account.setFname(rs.getString("FNAME"));
		account.setLname(rs.getString("LNAME"));
		account.setEmail(rs.getString("EMAIL"));
		account.setAccount_name(rs.getString("ACCOUNT_NAME"));
		account.setPassword(rs.getString("PASSWORD"));
		return account;
	}

}
