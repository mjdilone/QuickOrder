package com.ds.quickOrder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.model.CartItem;
import com.ds.quickOrder.model.CartItemRowMapper;
import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.model.SaleItemRowMapper;

@Component
@Transactional
@Repository
public class CartDaoImpl implements CartDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SaleItemDao saleItemDao;
	
	@Override
	public void addToCart(int itemId, int userId,int quantity) {
		SaleItemRowMapper mapper = new SaleItemRowMapper();
		SaleItem itemToAdd = jdbcTemplate.queryForObject(("select * from sale_item where id =  " + itemId), mapper);
		String query = "insert into cart_items values (" +  userId + " , " +  "NOW()"  + "," +  "'" + itemToAdd.getName() + "'" + "," + quantity + ")";
		
		jdbcTemplate.execute(query);
	}

	@Override
	public List<CartItem> retrieveCart(int userId) {
		System.out.println("beggining retrieveCart Dao");
		
		String query = "select * from cart_items where customer_id = " + userId;
		List<CartItem> cart = jdbcTemplate.query(query, new CartItemRowMapper());
		cart = aggregateCartItems(cart);
		setImageSources(cart);
		System.out.println("Completing retrieveCartDao");
		return cart;
	}

	@Override
	public List<CartItem> retrieveGuestCart(int userId) {
		String query = "select * from guest_cart_items where customer_id = " + userId;
		System.out.println("the query in retreiveCart: " + query);
		List<CartItem> cart = jdbcTemplate.query(query, new CartItemRowMapper());
		cart = aggregateCartItems(cart);
		setImageSources(cart);
		
		return cart;
	}
	

@Override
	public void addToGuestCart(int itemId, int userId, int quantity) {
		SaleItemRowMapper mapper = new SaleItemRowMapper();
		SaleItem itemToAdd = jdbcTemplate.queryForObject(("select * from sale_item where id =  " + itemId), mapper);
		String query = "insert into guest_cart_items values (" +  userId + " , " +  "NOW()"  + "," +  "'" + itemToAdd.getName() + "'" + "," + quantity + ")";
		
		jdbcTemplate.execute(query);
	}

	@Override
	public void setImageSources(List<CartItem> cart) {
		if(cart != null) {
			for(CartItem i: cart) {
				i.setImageSource(saleItemDao.findSaleItemByName(i.getName()).getImageSource());
				
			}
		}
		
	}

	@Override
	public List<CartItem> aggregateCartItems(List<CartItem> cart) {
		List<CartItem> newCart =  new ArrayList<>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(CartItem item : cart) {
			if(!map.containsKey(item.getName())) {
				map.put(item.getName(),item.getName().hashCode());
				newCart.add(item);
			}else {
				for(CartItem itemToIncrement : newCart) {
					if(itemToIncrement.getName().equals(item.getName())) {
						itemToIncrement.addQuantity(item.getQuantity());
					}
				}
			}
		}
		return newCart;
	}

}
