package com.ds.quickOrder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.AccountEntity;
import com.ds.quickOrder.model.AccountRowMapper;
import com.ds.quickOrder.model.PastOrderItem;
import com.ds.quickOrder.model.PastOrderItemRowMapper;
import com.ds.quickOrder.model.User;
import com.ds.quickOrder.model.UserEntity;
import com.ds.quickOrder.model.UserRowMapper;
import com.ds.quickOrder.repo.AccountRepo;
import com.ds.quickOrder.repo.UserRepo;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	private static Logger log = LoggerFactory.getLogger(AccountDaoImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	AccountRepo repo;
	
	AccountRowMapper accountRowMapper = new AccountRowMapper();
	PastOrderItemRowMapper pastOrderItemMapper = new PastOrderItemRowMapper();
	UserRowMapper UserRowMapper = new UserRowMapper();
	
	@Autowired
	UserRepo userRepo;
	
	//JDBC
//	@Override
//	public Account retrieveAccount(String username) {
//		log.info("Username: " + username);
//		if(username.isEmpty() || username.equalsIgnoreCase("guest")) {
//			return new Account();
//		}else {
//			String query = "select * from customer_accounts where account_name ='" + username + "'";
//			Account accountToRetrieve = jdbcTemplate.queryForObject(query, accountRowMapper);
//			
//			return accountToRetrieve;
//		}
//		
//	}

	//hibernate
	public Account retrieveAccount(String username) {
		log.info("Username: " + username);
		if(username.isEmpty() || username.equalsIgnoreCase("guest")) {
			return new AccountEntity();
		}else {
			AccountEntity accountToRetrieve = repo.findByAccount_Name(username);
			return accountToRetrieve;
		}
	}
	
	
//	JDBC
//	@Override
//	public List<PastOrderItem> retrievePastOrders(String username) {
//		String query = "select * from past_order_items where customer_name = " + username;
//		List<PastOrderItem> result = jdbcTemplate.query(query, pastOrderItemMapper);
//		
//		return result;
//	}
	
//	@Override
//	public List<PastOrderItem> retrievePastOrders(String username) {
//		String query = "select * from past_order_items where customer_name = " + username;
//		List<PastOrderItem> result = jdbcTemplate.query(query, pastOrderItemMapper);
//		
//		
//		
//		return result;
//	}
	
////	@Override
//	public List<PastOrderItem> retrievePastOrdersHibernate(String username) {
//		String query = "select * from past_order_items where customer_name = " + username;
//		List<PastOrderItem> result = jdbcTemplate.query(query, pastOrderItemMapper);
//		
//		return result;
//	}

//	JDBC
//	@Override
//	public List<PastOrderItem> retrievePastOrders(int userId) {
//		String query = "select * from past_order_items where customer_id = " + userId;
//		List<PastOrderItem> result = jdbcTemplate.query(query, pastOrderItemMapper);
//		
//		result = aggregatePastOrderItems(result);
//		return result;
//	}
	
	//hibernate
	@Override
	public List<PastOrderItem> retrievePastOrders(int userId) {
		List<PastOrderItem> result = null;
		try {
			result = repo.findPastOrders(userId);
			result = aggregatePastOrderItems(result);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("repo has failed");
		}
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

//	JDBC
//	@Override
//	public void addNewUser(User user) {
//		String query = "insert into users values " + "(" + "null," + "'" + user.getFname() + "'" + "," + "'" + user.getLname() + "'" + "," + "'" + user.getEmail() + "'" + "," + "'" + user.getPassword() + "'" +
//				"," +"'" +  user.getUname()+ "'" + ")";
//		
//		log.info("Query in addNewUser: " + query);
//		try {
//			jdbcTemplate.execute(query);
//		} catch (Exception e) {
//			log.info("somehting happened with the sql");
//			e.printStackTrace();
//		}
//		
//	}

	//hibernate
	@Override
	public void addNewUser(User user) {
		try {
			userRepo.save(new UserEntity(user));
		} catch (Exception e) {
			log.info("somehting happened with the sql");
			e.printStackTrace();
		}
	}
	
//	JDBC
//	@Override
//	public Boolean addNewAccount(Account account) {
//		String query = "insert into customer_accounts values " + 
//				"(" + "null," + "'" + 
//				account.getFname() + "'" + "," + "'" + 
//				account.getLname() + "'" + "," + "'" + 
//				account.getEmail() + "'" + "," + "'" + 
//				account.getAccount_name() + "'" +"," +"'" +  
//				account.getPassword()+ "'" + ")";
//		
//		log.info("Query in addNewAccount: " + query);
//		
//		try {
//			jdbcTemplate.execute(query);
//			return true;
//		} catch (DuplicateKeyException e) {
//			log.info("an account with that username already exists");
//			e.printStackTrace();
//			return false;
//		}catch(Exception e) {
//			return false;
//		}
//	}
//	
	
	//hibernate
	@Override
	public Boolean addNewAccount(Account account) {
		try {
			repo.save(new AccountEntity(account));
			return true;
		} catch (DuplicateKeyException e ) {
			log.info("an account with that username already exists");
			e.printStackTrace();
			return false;
		}
	catch(ConstraintViolationException e) {
		log.info("the SQL query has broken an SQL constraint");
		return false;
	}catch(Exception e) {
		log.info("a general error has occurred in account dao");
		return false;
		}
	}


	@Override
	public Account retrieveAccount(int id) {
		Optional<AccountEntity> accountEntity = null;
		
		accountEntity = repo.findById(id);
		Account account = accountEntity.get();
		return account;
	}
	
	
	public Boolean isGuest(int userId) {
		Boolean isGuest = null;
		
		try {
			isGuest = !repo.existsById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("isGuest failed");
			return false;
		}
		
		
		return isGuest;
	}
	
}
