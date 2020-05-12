//return a cart here and then append the names and quantities of each cart item to the email draft, check if only guest cart is getting pictures
		//TODO cart isn't grouping together similar named items
		//TODO no search bar
		//TODO gotta start making the pages look nicer
package com.ds.quickOrder.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.Constants;
import com.ds.quickOrder.controller.CartController;
import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.AccountRowMapper;
import com.ds.quickOrder.model.CartItem;
import com.ds.quickOrder.model.CartItemRowMapper;
import com.ds.quickOrder.repo.AccountRepo;

@Transactional
@Repository
public class CheckoutDaoImpl implements CheckoutDao{
	private static Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SaleItemDao saleItemDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Override
	public String prepareCheckoutEmail(int id) {
		StringBuilder emailDraft = new StringBuilder();
		
		emailDraft.append(Constants.getEmailHeader(retrieveUserFNameAndLName(id), id));
		System.out.println("Draft Before appending the cart items: " + emailDraft.toString());
		List<CartItem> cart = null;
		
		if(isGuest(id)) {
			 //cart = retrieveGuestCart(id);
			 cart = cartDao.retrieveGuestCart(id);
		}else {
			 //cart = retrieveCart(id);
			cart = cartDao.retrieveCart(id);
		}
		
		for(CartItem i : cart) {
			//emailDraft.append("this is in the draft");
			emailDraft.append(i.getName() + ":" + i.getQuantity());
			emailDraft.append("\n");
		}
		
		System.out.println("email draft after appending items.......");
		System.out.println(emailDraft.toString());
		return emailDraft.toString();
	}

	
	//JDBC
//	@Override
//	public String retrieveUserFNameAndLName(int id) {
//		String query = "select * from customer_accounts where id = '" + id + "'";
//		
//		System.out.println("query in User retrieval for checkout is " + query);
//		
//		RowMapper<Account> rowMapper = new AccountRowMapper();
//		Account account = new Account();
//		account = jdbcTemplate.queryForObject(query, rowMapper);
//		
//		
//		
//		
//		String name = account.getFname() + " " +  account.getLname();
//		return name;
//	}
	
	//Hibernate
	@Override
	public String retrieveUserFNameAndLName(int id) {
		Account account = new Account();
		
		try {
			account = accountDao.retrieveAccount(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name = account.getFname() + " " +  account.getLname();
		return name;
	}

//	//JDBC
//	@Override
//	public Boolean isGuest(int userid) {
//		String query = "select * from customer_accounts where id = '" + userid + "'";
//		RowMapper<Account> rowMapper = new AccountRowMapper();
//		Account account = new Account();
//	
//		try {
//			account = jdbcTemplate.queryForObject(query, rowMapper);
//		} catch (EmptyResultDataAccessException emptyResultError) {
//			return true;
//		}
//		
//		if (account != null) {
//			return false;
//		}else {
//			return true;
//		}
//	}
	
	//Hibernate
	@Override
	public Boolean isGuest(int userId) {
		Boolean isGuest = null;
		try {
			isGuest = accountDao.isGuest(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isGuest;
	}

//	//JDBC
//	@Override
//	public void checkout(int id) {
//		
//		if(isGuest(id)) {
//			log.info("********* Guest Checkout being called");
//			String queryToCopyCartToPastOrders = "insert into past_order_items  select * from cart_items where customer_id = " + id; 
//			String queryToDeleteCart = "delete  from guest_cart_items where customer_id = " + id ;
//			
//			jdbcTemplate.execute(queryToCopyCartToPastOrders);
//			jdbcTemplate.execute(queryToDeleteCart);
//		}else {
//			log.info("********* User Checkout being called");
//			String queryToCopyCartToPastOrders = "insert into past_order_items  select * from cart_items where customer_id = " + id; 
//			String queryToDeleteCart = "delete  from cart_items where customer_id = " + id ;
//			
//			jdbcTemplate.execute(queryToCopyCartToPastOrders);
//			jdbcTemplate.execute(queryToDeleteCart);
//		}
//
//	}
	
	//Hibernate
	//TODO implement the delete query into the repo
	@Override
	public void checkout(int id) {
		if(isGuest(id)) {
			log.info("********* Guest Checkout being called");
			cartDao.cartGuestCheckout(id);
		}else {
			log.info("********* User Checkout being called");
			cartDao.cartCheckout(id);
		}
	}
}