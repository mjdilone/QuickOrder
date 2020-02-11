//return a cart here and then append the names and quantities of each cart item to the email draft, check if only guest cart is getting pictures
		//TODO cart isn't grouping together similar named items
		//TODO no search bar
		//TODO gotta start making the pages look nicer
package com.ds.quickOrder.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.Constants;
import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.AccountRowMapper;
import com.ds.quickOrder.model.CartItem;
import com.ds.quickOrder.model.CartItemRowMapper;

@Transactional
@Repository
public class CheckoutDaoImpl implements CheckoutDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SaleItemDao saleItemDao;
	
	@Autowired
	CartDao cartDao;
	
	
	
	@Override
	public String prepareCheckoutEmail(int id) {
		StringBuilder emailDraft = new StringBuilder();
		
		emailDraft.append(Constants.getEmailHeader(retrieveUserFNameAndLName(id), id));
		System.out.println("Draft Before appending the cart items: " + emailDraft.toString());
		List<CartItem> cart ;
		
		if(isGuest(id)) {
			 //cart = retrieveGuestCart(id);
			 cart = cartDao.retrieveCart(id);
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

	@Override
	public String retrieveUserFNameAndLName(int id) {
		String query = "select * from customer_accounts where id = '" + id + "'";
		
		System.out.println("query in User retrieval for checkout is " + query);
		
		RowMapper<Account> rowMapper = new AccountRowMapper();
		Account account = new Account();
		account = jdbcTemplate.queryForObject(query, rowMapper);
		
		String name = account.getFname() + " " +  account.getLname();
		return name;
	}

//	@Override
//	public List<CartItem> retrieveCart(int userId) {
//		String query = "select * from cart_items where customer_id = " + userId;
//		List<CartItem> cart = jdbcTemplate.query(query, new CartItemRowMapper());
//		
//		for(CartItem i: cart) {
//			i.setImageSource(saleItemDao.findSaleItemByName(i.getName()).getImageSource());
//		}
//		return cart;
//	}

//	@Override
//	public List<CartItem> retrieveGuestCart(int userId) {
//		String query = "select * from guest_cart_items where customer_id = " + userId;
//		//System.out.println("the query in retreiveCart: " + query);
//		List<CartItem> cart = jdbcTemplate.query(query, new CartItemRowMapper());
//		
//		for(CartItem i: cart) {
//			i.setImageSource(saleItemDao.findSaleItemByName(i.getName()).getImageSource());
//		}
//		return cart;
//	}

	@Override
	public Boolean isGuest(int userid) {
		String query = "select * from customer_accounts where id = '" + userid + "'";
		RowMapper<Account> rowMapper = new AccountRowMapper();
		Account account = new Account();
		account = jdbcTemplate.queryForObject(query, rowMapper);
		
		if (account != null) {
			return false;
		}else {
			return true;
		}
		
		
	}

	public void checkout(int id) {
		String queryToCopyCartToPastOrders = "insert into past_order_items  select * from cart_items where customer_id = " + id; 
		String queryToDeleteCart = "delete  from cart_items where customer_id = " + id ;
		
		jdbcTemplate.execute(queryToCopyCartToPastOrders);
		jdbcTemplate.execute(queryToDeleteCart);
		
		
		
	}
	
	

}
