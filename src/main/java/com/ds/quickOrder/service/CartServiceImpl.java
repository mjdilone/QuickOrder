package com.ds.quickOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.quickOrder.dao.CartDaoImpl;
import com.ds.quickOrder.model.CartItem;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDaoImpl cartDao;
	
	@Override
	public List<CartItem> retrieveCart(int userId) {
		
		return cartDao.retrieveCart(userId);
	}

	@Override
	public void addToCart(int itemId,int userId,int quantity) {
		cartDao.addToCart(itemId,userId,quantity);
	}

	@Override
	public void addToGuestCart(int itemId, int userId, int quantity) {
		cartDao.addToGuestCart(itemId,userId,quantity);
	}

	@Override
	public List<CartItem> retrieveGuestCart(int userId) {
		
		return cartDao.retrieveGuestCart(userId);
	}
	
	

}
