package com.ds.quickOrder.dao;

import com.ds.quickOrder.model.Account;

public interface LoginDao {
	public Account retrieveAccount(String username);
}
