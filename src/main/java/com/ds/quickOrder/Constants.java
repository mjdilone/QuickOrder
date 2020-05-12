package com.ds.quickOrder;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.ds.quickOrder.service.CartServiceImpl;

//@Configuration
public  class Constants {
	
	@Autowired
	CartServiceImpl cartService;

	public static final Integer genGuestUserId() {
		Calendar cal = Calendar.getInstance();
		Integer result  = (int) cal.getTimeInMillis();
		result = result + ((int)(Math.random() * 10000));
		
		return result;
	}
	
	public static final String getEmailHeader(String name, int id) {
		String draft = "Hello! \n " + "The customer " + name + ":" + id + " has ordered \n";
		return draft;
}
	public static final String testCompanyName= "MC"; 
	public static final String duplicateUserNameMessage = "Username is empty/already exists, please enter another username";

	public static final String QUERY_HEADER = "SQL QUERY: " ;
	public static final int QUERY_SEARCH_LIMIT = 10;
	
	//table names for hibernate
	public static final String TABLE_NAME_CUSTOMER_ACCOUNTS = "customer_accounts";
	public static final String TABLE_NAME_CART_ITEMS = "cart_items";
	public static final String TABLE_NAME_GUEST_CART_ITEMS = "guest_cart_items";
	public static final String TABLE_NAME_CATEGORIES = "categories";
	public static final String TABLE_NAME_SALE_ITEMS = "sale_item";
	public static final String TABLE_NAME_USERS = "users";
	public static final String TABLE_NAME_COMPANY = "company";
	public static final String TABLE_NAME_PASTORDERITEMS = "past_order_items";
	
	public static final int testGuestUserId = 848693832;
}