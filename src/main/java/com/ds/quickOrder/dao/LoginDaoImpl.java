package com.ds.quickOrder.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.AccountRowMapper;

@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<Account> rowMapper = new AccountRowMapper();
	
	@Override
	public Account retrieveAccount(String username) {
		String query = "select * from customer_accounts where account_name = '" + username + "'";
		System.out.println("query in account retrieval is " + query);
		
		Account account = new Account();

		account = jdbcTemplate.queryForObject(query, rowMapper);

		return account;
	}
}