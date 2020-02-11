package com.ds.quickOrder.dao;

import java.util.List;

import com.ds.quickOrder.model.CartItem;

public interface CartDao {
	public List<CartItem> retrieveCart (int userId);
	public List<CartItem> retrieveGuestCart(int userId);
	public void addToCart(int itemId,int userId,int quantity);
	public void addToGuestCart(int itemId,int userId,int quantity);
	public void setImageSources(List<CartItem> cart);
	public List<CartItem> aggregateCartItems(List<CartItem> cart);
}
