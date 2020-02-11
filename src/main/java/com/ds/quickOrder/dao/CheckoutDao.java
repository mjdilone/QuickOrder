package com.ds.quickOrder.dao;

import java.util.List;

import com.ds.quickOrder.model.CartItem;

public interface CheckoutDao {
	public String prepareCheckoutEmail(int id);
	public String retrieveUserFNameAndLName(int id);
//	public List<CartItem> retrieveCart (int userId);
//	public List<CartItem> retrieveGuestCart(int userId);
	public Boolean isGuest(int userid);
	public void checkout(int id);
}
