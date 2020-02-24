package com.ds.quickOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.quickOrder.dao.AccountDaoImpl;
import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.PastOrderItem;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDaoImpl accountDao;

	@Override
	public Account retrieveAccount(String username) {
		if(username.equalsIgnoreCase("Guest") || username.length() <= 0) {
			return new Account("Guest");
		}
		Account accountToRetrieve = new Account();
		try {
			 accountToRetrieve = accountDao.retrieveAccount(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return accountToRetrieve;
	}

	@Override
	public List<PastOrderItem> retrievePastOrders(String username) {
		List<PastOrderItem> pastOrders = null;
		
		try {
			pastOrders = accountDao.retrievePastOrders(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pastOrders;
	}

	@Override
	public List<PastOrderItem> retrievePastOrders(int userId) {
		List<PastOrderItem> pastOrders = null;
		
		 try {
			pastOrders = accountDao.retrievePastOrders(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pastOrders;
	}
}