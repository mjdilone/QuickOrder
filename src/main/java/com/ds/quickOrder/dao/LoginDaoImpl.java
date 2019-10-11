package com.ds.quickOrder.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.AccountRowMapper;
import com.ds.quickOrder.model.SaleItem;

@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Account retrieveAccount(String username) {
		String query = "select * from customer_accounts where account_name = '" + username + "'";
		System.out.println("query in account retrieval is " + query);
		RowMapper<Account> rowMapper = new AccountRowMapper();
		Account account = new Account();
		account = jdbcTemplate.queryForObject(query, rowMapper);

		
		return account;
	}


	
	

}
