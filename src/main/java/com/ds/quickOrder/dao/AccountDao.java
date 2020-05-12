package com.ds.quickOrder.dao;

import java.util.List;

import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.PastOrderItem;
import com.ds.quickOrder.model.User;

public interface AccountDao {
	public Account retrieveAccount(String username);
	public Account retrieveAccount(int id);
//	public List<PastOrderItem> retrievePastOrders(String username);
	public List<PastOrderItem> retrievePastOrders(int userId);
	public List<PastOrderItem> aggregatePastOrderItems(List<PastOrderItem> cart);
	public void addNewUser(User user);
	public Boolean addNewAccount(Account account);
	public Boolean isGuest(int userId);
}