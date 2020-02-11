package com.ds.quickOrder.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.quickOrder.controller.CartController;
import com.ds.quickOrder.dao.CartDaoImpl;
import com.ds.quickOrder.model.CartItem;

@Service
public class CartServiceImpl implements CartService{
	
	private static Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartDaoImpl cartDao;
	
	@Override
	public List<CartItem> retrieveCart(int userId) {
		List<CartItem> cart = null;
			
				log.info("Method Entry: " + new Object(){}.getClass().getEnclosingMethod().getName());
				log.info("UserId: " + userId);
				
				
				cart = cartDao.retrieveCart(userId);
				log.info("Cart has been made");
			return cart;
	}
	
	@Override
	public void addToCart(int itemId,int userId,int quantity) {
		try {
			cartDao.addToCart(itemId,userId,quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addToGuestCart(int itemId, int userId, int quantity) {
		try {
			cartDao.addToGuestCart(itemId,userId,quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CartItem> retrieveGuestCart(int userId) {
		List<CartItem> cart = null;
		try {
			cart = cartDao.retrieveGuestCart(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	

}
