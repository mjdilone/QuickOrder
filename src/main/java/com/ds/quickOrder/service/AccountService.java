package com.ds.quickOrder.service;

import java.util.List;

import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.PastOrderItem;

public interface AccountService {
	public Account retrieveAccount(String username);
	public List<PastOrderItem> retrievePastOrders(String username);
	public List<PastOrderItem> retrievePastOrders(int userId);
	
	
}
