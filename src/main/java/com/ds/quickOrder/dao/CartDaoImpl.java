package com.ds.quickOrder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ds.quickOrder.model.CartItem;
import com.ds.quickOrder.model.CartItemRowMapper;
import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.model.SaleItemEntity;
import com.ds.quickOrder.model.SaleItemRowMapper;
import com.ds.quickOrder.repo.CartItemRepo;
import com.ds.quickOrder.repo.SaleItemRepo;

@Component
@Transactional
@Repository
public class CartDaoImpl implements CartDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SaleItemDaoImpl saleItemDao;
	
	@Autowired
	SaleItemRepo saleRepo;
	
	@Autowired
	CartItemRepo repo;
	
	//JDBC
//	@Override
//	public void addToCart(int itemId, int userId,int quantity) {
//		SaleItemRowMapper mapper = new SaleItemRowMapper();
//		SaleItem itemToAdd = jdbcTemplate.queryForObject(("select * from sale_item where id =  " + itemId), mapper);
//		String query = "insert into cart_items values (" +  userId + " , " +  "NOW()"  + "," +  "'" + itemToAdd.getName() + "'" + "," + quantity + ")";
//		
//		jdbcTemplate.execute(query);
//	}
	
	//Hibernate
	@Override
	public void addToCart(int itemId, int userId,int quantity) {
		Optional<SaleItemEntity> itemToAdd;
		SaleItemEntity itemToAddEntity = null;
		
		try {
			itemToAdd = saleRepo.findById(itemId);
			itemToAddEntity = itemToAdd.get();
		} catch (Exception e) {
		}
		
		repo.saveWithTimeStamp(userId,itemToAddEntity.getName(),quantity);
	}
	
//	//JDBC
//	@Override
//	public void addToGuestCart(int itemId, int userId, int quantity) {
//		SaleItemRowMapper mapper = new SaleItemRowMapper();
//		SaleItem itemToAdd = jdbcTemplate.queryForObject(("select * from sale_item where id =  " + itemId), mapper);
//		
//		
//		String query = "insert into guest_cart_items values (" +  userId + " , " +  "NOW()"  + "," +  "'" + itemToAdd.getName() + "'" + "," + quantity + ")";
//		
//		jdbcTemplate.execute(query);
//		
//		
//	}
	
	//Hibernate
	@Override
	public void addToGuestCart(int itemId, int userId, int quantity) {
		Optional<SaleItemEntity> itemToAdd;
		SaleItemEntity itemToAddEntity = null;
		
		try {
			itemToAdd = saleRepo.findById(itemId);
			itemToAddEntity = itemToAdd.get();
		} catch (Exception e) {
		}
		
		repo.saveWithTimeStampGuest(userId,itemToAddEntity.getName(),quantity);
	}

	
	
	
	
	
	
	
	
//	//JDBC
//	@Override
//	public List<CartItem> retrieveCart(int userId) {
//		System.out.println("beggining retrieveCart Dao");
//		
//		String query = "select * from cart_items where customer_id = " + userId;
//		List<CartItem> cart = jdbcTemplate.query(query, new CartItemRowMapper());
//		cart = aggregateCartItems(cart);
//		setImageSources(cart);
//		System.out.println("Completing retrieveCartDao");
//		return cart;
//	}
	
	//Hibernate
	@Override
	public List<CartItem> retrieveCart(int userId) {
		List<CartItem> cart = null;
		try {
			cart = repo.findByUserId(userId);
			cart = aggregateCartItems(cart);
		} catch (Exception e) {
			// TODO: handle exception
		}
		setImageSources(cart);
		return cart;
	}

//	//JDBC
//	@Override
//	public List<CartItem> retrieveGuestCart(int userId) {
//		String query = "select * from guest_cart_items where customer_id = " + userId;
//		System.out.println("the query in retreiveCart: " + query);
//		List<CartItem> cart = jdbcTemplate.query(query, new CartItemRowMapper());
//		cart = aggregateCartItems(cart);
//		setImageSources(cart);
//		
//		return cart;
//	}
	
	//Hibernate
	@Override
	public List<CartItem> retrieveGuestCart(int userId) {
		List<CartItem> cart = null;

		try {
			cart = repo.findByGuestUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cart = aggregateCartItems(cart);
		setImageSources(cart);
		return cart;
	}
	
	//util
	@Override
	public void setImageSources(List<CartItem> cart) {
		if(cart != null) {
			for(CartItem i: cart) {
				i.setImageSource(saleItemDao.findSaleItemByName(i.getName()).getImageSource());
			}
		}
	}

	//util
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

	@Override
	public void cartCheckout(int id) {
		repo.copyCartToPastOrders(id);
		repo.deleteWithCustomer_Id(id);
	}

	@Override
	public void cartGuestCheckout(int id) {
		repo.copyGuestCartToPastOrders(id);
		repo.deleteWithGuest_Id(id);
	}
}