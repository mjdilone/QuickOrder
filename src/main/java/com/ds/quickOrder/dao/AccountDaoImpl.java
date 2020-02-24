package com.ds.quickOrder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.AccountRowMapper;
import com.ds.quickOrder.model.PastOrderItem;
import com.ds.quickOrder.model.PastOrderItemRowMapper;

@Repository
public class AccountDaoImpl implements AccountDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	AccountRowMapper accountRowMapper = new AccountRowMapper();
	PastOrderItemRowMapper pastOrderItemMapper = new PastOrderItemRowMapper();
	
	//no defense against an empty account, in other words a guest
	@Override
	public Account retrieveAccount(String username) {
		System.out.println("Username: " + username);
		if(username.isEmpty() || username.equalsIgnoreCase("guest")) {
			return new Account();
		}else {
			String query = "select * from customer_accounts where account_name ='" + username + "'";
			Account accountToRetrieve = jdbcTemplate.queryForObject(query, accountRowMapper);
			
			return accountToRetrieve;
		}
		
	}


	@Override
	public List<PastOrderItem> retrievePastOrders(String username) {
		String query = "select * from past_order_items where customer_name = " + username;
		List<PastOrderItem> result = jdbcTemplate.query(query, pastOrderItemMapper);
		
		return result;
	}


	@Override
	public List<PastOrderItem> retrievePastOrders(int userId) {
		String query = "select * from past_order_items where customer_id = " + userId;
		List<PastOrderItem> result = jdbcTemplate.query(query, pastOrderItemMapper);
		
		result = aggregatePastOrderItems(result);
		return result;
	}
	
	@Override
	public List<PastOrderItem> aggregatePastOrderItems(List<PastOrderItem> cart) {
		List<PastOrderItem> newCart =  new ArrayList<>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(PastOrderItem item : cart) {
			if(!map.containsKey(item.getName())) {
				map.put(item.getName(),item.getName().hashCode());
				newCart.add(item);
			}else {
				for(PastOrderItem itemToIncrement : newCart) {
					if(itemToIncrement.getName().equals(item.getName())) {
						itemToIncrement.addQuantity(item.getQuantity());
					}
				}
			}
		}
		return newCart;
	}

}
