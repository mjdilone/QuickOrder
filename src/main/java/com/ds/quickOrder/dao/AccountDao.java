package com.ds.quickOrder.dao;

import java.util.List;

import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.PastOrderItem;

public interface AccountDao {
	public Account retrieveAccount(String username);
	public List<PastOrderItem> retrievePastOrders(String username);
	public List<PastOrderItem> retrievePastOrders(int userId);
	public List<PastOrderItem> aggregatePastOrderItems(List<PastOrderItem> cart);
}
