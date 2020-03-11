package com.ds.quickOrder.service;

import java.util.List;

import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.PastOrderItem;
import com.ds.quickOrder.model.User;

public interface AccountService {
	public Account retrieveAccount(String username);
	public List<PastOrderItem> retrievePastOrders(String username);
	public List<PastOrderItem> retrievePastOrders(int userId);
	public void signUpNewUser(User user);
	
}
