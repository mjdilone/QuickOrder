package com.ds.quickOrder.service;

import java.util.ArrayList;
import java.util.List;

import com.ds.quickOrder.model.CartItem;

public interface CartService {
	public List<CartItem> retrieveCart(int userId);
	public List<CartItem> retrieveGuestCart(int userId);
	public void addToCart(int itemId, int userId,int quantity);
	public void addToGuestCart(int itemId, int userId,int quantity);
}
